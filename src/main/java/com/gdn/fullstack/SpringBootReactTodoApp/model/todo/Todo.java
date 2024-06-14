package com.gdn.fullstack.SpringBootReactTodoApp.model.todo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gdn.fullstack.SpringBootReactTodoApp.model.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "todos")
public class Todo {
    @Id
    @GeneratedValue
    private int id;
    @Size(min = 5, message = "Title should be at least 5 characters long!")
    private String title;
    @Size(min = 2, message = "Comment should be at least 2 characters long!")
    private String comment;
    private LocalDateTime deadLine;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean done;
    @ManyToOne
    @JsonIgnore
    private User user;
    
    public Todo(int id, String title, String comment, LocalDateTime deadLine, LocalDateTime updatedAt, boolean done) {
        this.id = id;
        this.title = title;
        this.comment = comment;
        this.deadLine = deadLine;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = updatedAt;
        this.done = done;
    }
    
    public Todo() {
        this.createdAt=LocalDateTime.now();
        this.updatedAt=null;
        this.done=false;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public @Size(min = 5, message = "Title should be at least 5 characters long!") String getTitle() {
        return title;
    }
    
    public void setTitle(@Size(min = 5, message = "Title should be at least 5 characters long!") String title) {
        this.title = title;
    }
    
    public @Size(min = 2, message = "Comment should be at least 2 characters long!") String getComment() {
        return comment;
    }
    
    public void setComment(@Size(min = 2, message = "Comment should be at least 2 characters long!") String comment) {
        this.comment = comment;
    }
    
    public LocalDateTime getDeadLine() {
        return deadLine;
    }
    
    public void setDeadLine(LocalDateTime deadLine) {
        this.deadLine = deadLine;
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
    
    public boolean isDone() {
        return done;
    }
    
    public void setDone(boolean done) {
        this.done = done;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", comment='" + comment + '\'' +
                ", deadLine=" + deadLine +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", done=" + done +
                ", user=" + user +
                '}';
    }
}
