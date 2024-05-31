package com.gdn.fullstack.SpringBootReactTodoApp.controller;

import com.gdn.fullstack.SpringBootReactTodoApp.exception.UserNotFoundException;
import com.gdn.fullstack.SpringBootReactTodoApp.model.user.User;
import com.gdn.fullstack.SpringBootReactTodoApp.model.user.UserRepository;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

public class UserResource {
    private final UserRepository userRepository;
    
    public UserResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    //CRUD:
    
    //create
    @PostMapping("/api/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userRepository.save(user);
        
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        
        return ResponseEntity.created(location).build();
    }
    
    //read
    @GetMapping("/api/users")
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }
    
    @GetMapping("/api/users/{userId}")
    public EntityModel<User> retrieveSpecificUser(@PathVariable int id) {
        Optional<User> userToFind = userRepository.findById(id);
        
        if (userToFind.isEmpty()) {
            throw new UserNotFoundException("id: " + id);
        }
        EntityModel<User> entityModel = EntityModel.of(userToFind.get());
        
        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }
    
    //update
    //TODO: implement userUpdating method!
    
    
    //delete
    @DeleteMapping("/api/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }
    
}
