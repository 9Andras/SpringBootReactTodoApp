package com.gdn.fullstack.SpringBootReactTodoApp.model.todo;

import com.gdn.fullstack.SpringBootReactTodoApp.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
}
