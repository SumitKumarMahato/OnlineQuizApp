package com.example.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quizapp.entity.AttemptAnswer;

public interface AttemptAnswerRepo extends JpaRepository<AttemptAnswer, Long> {
	

}
