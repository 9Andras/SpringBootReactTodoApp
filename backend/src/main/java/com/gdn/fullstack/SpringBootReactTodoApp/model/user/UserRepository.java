package com.gdn.fullstack.SpringBootReactTodoApp.model.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
     public Optional<User> findByEmailAddress(String emailAddress);
     public Optional<User> findByUsername(String username);
}
