package com.example.quizapp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizapp.service.AttemptService;

@RestController
@RequestMapping("/api/attempt")
public class AttemptAnswerController {

	@Autowired
	private AttemptService attemptService;
	
	
	@PostMapping("/answer")
	public Map<String, Object> answer(@RequestParam Long attemptId,
									  @RequestParam Long questionId,
									  @RequestParam(required = false) List<Long> selectedOptionIds){
		
		return attemptService.answerQuestion(attemptId, questionId, selectedOptionIds);
	}
}
