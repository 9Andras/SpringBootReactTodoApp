package com.gdn.fullstack.SpringBootReactTodoApp.controller;

import com.gdn.fullstack.SpringBootReactTodoApp.exception.TodoNotFoundException;
import com.gdn.fullstack.SpringBootReactTodoApp.exception.UserNotFoundException;
import com.gdn.fullstack.SpringBootReactTodoApp.model.todo.Todo;
import com.gdn.fullstack.SpringBootReactTodoApp.model.todo.TodoRepository;
import com.gdn.fullstack.SpringBootReactTodoApp.model.user.User;
import com.gdn.fullstack.SpringBootReactTodoApp.model.user.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class TodoResource {
    private final TodoRepository todoRepository;
    private final UserRepository userRepository;
    
    public TodoResource(TodoRepository todoRepository, UserRepository userRepository) {
        this.todoRepository = todoRepository;
        this.userRepository = userRepository;
    }
    
    
    //CRUD:
    //Create
    @PostMapping("/api/users/{userId}/todos")
    public ResponseEntity<Object> createTodoForUser(@PathVariable int id, @Valid @RequestBody Todo todo) {
        Optional<User> userToFind = userRepository.findById(id);
        
        if (userToFind.isEmpty()) {
            throw new UserNotFoundException("id: " + id);
        }
        
        todo.setUser(userToFind.get());
        
        Todo todoToSave = todoRepository.save(todo);
        
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(todoToSave.getId())
                .toUri();
        
        return ResponseEntity.created(location).build();
    }
    
    //Read
    @GetMapping("/api/users/{userId}/todos")
    public List<Todo> retrieveTodosOfUser(@PathVariable int id) {
        Optional<User> userToFind = userRepository.findById(id);
        
        if (userToFind.isEmpty()) {
            throw new UserNotFoundException("id: " + id);
        }
        
        return userToFind.get().getTodos();
    }
    
    //Update
    //TODO:Implement todo updating method!
    
    
    //Delete
    @DeleteMapping("/api/users/{id}/todos/{id}")
    public ResponseEntity<Object> deleteTodoOfUser(@PathVariable int userId, @PathVariable int postId) {
        Optional<User> userToFind = userRepository.findById(userId);
        
        if (userToFind.isEmpty()) {
            throw new UserNotFoundException("id: " + userId);
        }
        User foundUser = userToFind.get();
        
        Optional<Todo> todoToFind = todoRepository.findById(postId);
        
        if (todoToFind.isEmpty() || !todoToFind.get().getUser().equals(foundUser)) {
            throw new TodoNotFoundException("id: " + postId);
        }
        
        Todo foundTodo = todoToFind.get();
        
        todoRepository.delete(foundTodo);
        return ResponseEntity.noContent().build();
    }
}
