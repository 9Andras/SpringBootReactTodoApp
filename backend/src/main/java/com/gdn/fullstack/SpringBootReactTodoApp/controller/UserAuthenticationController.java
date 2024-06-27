package com.gdn.fullstack.SpringBootReactTodoApp.controller;

import com.gdn.fullstack.SpringBootReactTodoApp.exception.ExistingEmailException;
import com.gdn.fullstack.SpringBootReactTodoApp.exception.ExistingUserException;
import com.gdn.fullstack.SpringBootReactTodoApp.exception.MissingFieldException;
import com.gdn.fullstack.SpringBootReactTodoApp.exception.UserNotFoundException;
import com.gdn.fullstack.SpringBootReactTodoApp.model.user.User;
import com.gdn.fullstack.SpringBootReactTodoApp.model.user.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserAuthenticationController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    
    //Login the user checking hashed passwords
    @GetMapping("/api/users/login")
    public ResponseEntity<?> loginUser(@PathVariable String emailAddress, @RequestBody Map<String, Object> userInfo) {
        
        //check if fields are filled out
        if (!userInfo.containsKey("emailAddress") || !userInfo.containsKey("password")) {
            throw new MissingFieldException("All fields must be filled out!");
        }
        
        //check if the user exists in the database
        Optional<User> user = userRepository.findByEmailAddress(emailAddress);
        if (user.isEmpty()) {
            throw new UserNotFoundException("email address: " + emailAddress);
        }
        
        User foundUser = user.get();
        
        //compare the incoming password with the user's password
        String incomingPassword = userInfo.get("password").toString();
        
        if (!passwordEncoder.matches(incomingPassword, foundUser.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
        
        //set password to null to not send it back to the frontend
        foundUser.setPassword(null);
        
        return ResponseEntity.ok(foundUser);
    }
    
    
    //Create/Register new user and save to database using jpa repository
    @PostMapping("/api/users/signup")
    public ResponseEntity<User> signupUser(@Valid @RequestBody User user) {
        
        //Check if all fields are filled out
        if (user.getUserName().isEmpty() || user.getEmailAddress().isEmpty() || user.getPassword().isEmpty()) {
            throw new MissingFieldException("All fields must be filled out. Check you credentials and try again.");
        }
        
        //Check if username is already in us
        Optional<User> existingUserName = userRepository.findByUsername(user.getUserName());
        if (existingUserName.isPresent()) {
            throw new ExistingUserException("Username is already in use. Please choose another and try again!");
        }
        
        //Check if email address is already in use
        Optional<User> existingEmailAddress = userRepository.findByEmailAddress(user.getEmailAddress());
        if (existingEmailAddress.isPresent()) {
            throw new ExistingEmailException("Email Address is already in use. Please use another!");
        }
        
        //hash password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        
        //Todo?: assign createdAt Date if required..
        //user.setCreatedAt(LocalDateTime.now());
        
        //Save user in the database
        User savedUser = userRepository.save(user);
        
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        
        return ResponseEntity.created(location).build();
    }
}
