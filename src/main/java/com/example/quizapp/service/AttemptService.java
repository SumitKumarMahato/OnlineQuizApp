package com.example.quizapp.service;

import java.util.List;
import java.util.Map;

import com.example.quizapp.entity.Attempt;

public interface AttemptService {

	Attempt startAttempt(String username, Long quizId);
	Map<String, Object> answerQuestion(Long attemptId, Long questionId, List<Long> selectedOptionIds);
	Attempt findById(Long id);
}
