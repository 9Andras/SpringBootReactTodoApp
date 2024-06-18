package com.gdn.fullstack.SpringBootReactTodoApp.controller;

import com.gdn.fullstack.SpringBootReactTodoApp.exception.TodoNotFoundException;
import com.gdn.fullstack.SpringBootReactTodoApp.exception.UserNotFoundException;
import com.gdn.fullstack.SpringBootReactTodoApp.model.todo.Todo;
import com.gdn.fullstack.SpringBootReactTodoApp.model.todo.TodoRepository;
import com.gdn.fullstack.SpringBootReactTodoApp.model.user.User;
import com.gdn.fullstack.SpringBootReactTodoApp.model.user.UserRepository;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;
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
    public ResponseEntity<Object> createTodoForUser(@PathVariable int userId, @Valid @RequestBody Todo todo) {
        
        Optional<User> userToFind = userRepository.findById(userId);
        
        
        if (userToFind.isEmpty()) {
            throw new UserNotFoundException("id: " + userId);
        }
        
        //todo.setCreatedAt(LocalDateTime.now());
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
    public List<Todo> retrieveTodosOfUser(@PathVariable int userId) {
        Optional<User> userToFind = userRepository.findById(userId);
        
        if (userToFind.isEmpty()) {
            throw new UserNotFoundException("id: " + userId);
        }
        
        return userToFind.get().getTodos();
    }
    
    //Update
    @PatchMapping("/api/users/{userId}/todos/{todoId}")
    public ResponseEntity<Object> updateTodoOfUser(@PathVariable int userId, @PathVariable int todoId, @RequestBody Map<String, Object> updates) {
        //Find user
        Optional<User> userToFind = userRepository.findById(userId);
        
        if (userToFind.isEmpty()) {
            throw new UserNotFoundException("id: " + userId);
        }
        //Find todo of user
        User foundUser = userToFind.get();
        
        Optional<Todo> todoToFind = todoRepository.findById(todoId);
        
        if (todoToFind.isEmpty() || !todoToFind.get().getUser().equals(foundUser)) {
            throw new TodoNotFoundException("id: " + todoId);
        }
        //updating todo
        Todo todoToUpdate = todoToFind.get();
        
        if (updates.containsKey("title")) {
            todoToUpdate.setTitle((String) updates.get("title"));
        }
        if (updates.containsKey("comment")) {
            todoToUpdate.setComment((String) updates.get("comment"));
        }
        if (updates.containsKey("deadLine")) {
            try {
                String deadLineString = (String) updates.get("deadLine");
                LocalDateTime deadLine = LocalDateTime.parse(deadLineString);
                todoToUpdate.setDeadLine(deadLine);
            } catch (DateTimeParseException e) {
                return ResponseEntity.badRequest().body("Invalid date format for deadline. Error: " + e.getMessage());
            }
        }
        if (updates.containsKey("done")) {
            todoToUpdate.setDone(!todoToUpdate.isDone());
        }
        //setting updatedAt value
        todoToUpdate.setUpdatedAt(LocalDateTime.now());
        
        //saving the todo
        Todo updatedTodo = todoRepository.save(todoToUpdate);
        EntityModel<Todo> entityModel = EntityModel.of(updatedTodo);
        
        return ResponseEntity.ok(entityModel);
    }
    
    //Delete
    @DeleteMapping("/api/users/{userId}/todos/{todoId}")
    public ResponseEntity<Object> deleteTodoOfUser(@PathVariable int userId, @PathVariable int todoId) {
        Optional<User> userToFind = userRepository.findById(userId);
        
        if (userToFind.isEmpty()) {
            throw new UserNotFoundException("id: " + userId);
        }
        User foundUser = userToFind.get();
        
        Optional<Todo> todoToFind = todoRepository.findById(todoId);
        
        if (todoToFind.isEmpty() || !todoToFind.get().getUser().equals(foundUser)) {
            throw new TodoNotFoundException("id: " + todoId);
        }
        
        Todo foundTodo = todoToFind.get();
        
        todoRepository.delete(foundTodo);
        return ResponseEntity.noContent().build();
    }
}
