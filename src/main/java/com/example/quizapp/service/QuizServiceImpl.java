package com.example.quizapp.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quizapp.entity.Quiz;
import com.example.quizapp.repository.QuizRepo;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuizRepo quizRepository;
	
	
	@Override
	public Quiz save(Quiz quiz) {
		// TODO Auto-generated method stub
		return quizRepository.save(quiz);
	}

	@Override
	public List<Quiz> findAll() {
		// TODO Auto-generated method stub
		return quizRepository.findAll();
	}

	@Override
	public Quiz findById(Long id) {
		// TODO Auto-generated method stub
		return quizRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		quizRepository.deleteById(id);	
	}

}
