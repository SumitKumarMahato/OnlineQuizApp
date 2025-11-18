package com.example.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quizapp.entity.Attempt;

public interface AttemptRepo extends JpaRepository<Attempt, Long> {
	

}
