package com.example.quizapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quizapp.entity.User;


public interface UserRepo extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);
}
