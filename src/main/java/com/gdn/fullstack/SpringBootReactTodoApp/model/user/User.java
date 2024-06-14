package com.gdn.fullstack.SpringBootReactTodoApp.model.user;

import com.gdn.fullstack.SpringBootReactTodoApp.model.todo.Todo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "user_details")
public class User {
    @Id
    @GeneratedValue
    private int id;
    @Size(min = 2, message = "User name should be at least 2 characters long!")
    private String userName;
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", flags = Pattern.Flag.CASE_INSENSITIVE)
    @NotEmpty(message = "Email cannot be empty")
    private String emailAddress;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @OneToMany(mappedBy = "user")
    private List<Todo> todos;
    public User(int id, String userName, String emailAddress, String password, List<Todo> todos) {
        this.id = id;
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = null;
        this.todos = todos;
    }
    public User() {
        this.createdAt=LocalDateTime.now();
        this.updatedAt=null;
        this.todos=new ArrayList<>();
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public @Size(min = 2, message = "User name should be at least 2 characters long!") String getUserName() {
        return userName;
    }
    
    public void setUserName(@Size(min = 2, message = "User name should be at least 2 characters long!") String userName) {
        this.userName = userName;
    }
    
    public @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", flags = Pattern.Flag.CASE_INSENSITIVE) @NotEmpty(message = "Email cannot be empty") String getEmailAddress() {
        return emailAddress;
    }
    
    public void setEmailAddress(@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", flags = Pattern.Flag.CASE_INSENSITIVE) @NotEmpty(message = "Email cannot be empty") String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    public List<Todo> getTodos() {
        return new ArrayList<>(todos);
    }
    
    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }
    
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", todos=" + todos +
                '}';
    }
}
