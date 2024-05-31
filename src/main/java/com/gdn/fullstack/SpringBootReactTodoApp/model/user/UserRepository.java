package com.gdn.fullstack.SpringBootReactTodoApp.model.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
