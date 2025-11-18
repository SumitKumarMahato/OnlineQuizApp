package com.example.quizapp.service;

import java.util.List;

import com.example.quizapp.entity.Quiz;

public interface QuizService {

	Quiz save(Quiz quiz);
	List<Quiz> findAll();
	Quiz findById(Long id);
	void deleteById(Long id);
	
}
