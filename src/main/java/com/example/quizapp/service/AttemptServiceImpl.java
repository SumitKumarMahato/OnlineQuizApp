package com.example.quizapp.service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quizapp.entity.Attempt;
import com.example.quizapp.entity.AttemptAnswer;
import com.example.quizapp.entity.Option;
import com.example.quizapp.entity.Question;
import com.example.quizapp.entity.Quiz;
import com.example.quizapp.entity.User;
import com.example.quizapp.repository.AttemptAnswerRepo;
import com.example.quizapp.repository.AttemptRepo;
import com.example.quizapp.repository.OptionRepo;
import com.example.quizapp.repository.QuestionRepo;
import com.example.quizapp.repository.QuizRepo;
import com.example.quizapp.repository.UserRepo;

@Service
public class AttemptServiceImpl implements AttemptService {
	
	@Autowired
	private UserRepo userRepository;
	@Autowired
	private QuizRepo quizRepository;
	@Autowired
	private QuestionRepo questionRepository;
	@Autowired
	private OptionRepo optionRepository;
	@Autowired
	private AttemptRepo attemptRepository;
	@Autowired
	private AttemptAnswerRepo attemptAnswerRepository;

	@Override
	public Attempt startAttempt(String username, Long quizId) {
		// TODO Auto-generated method stub
		User user = userRepository.findByUsername(username).orElse(null);
		Quiz quiz = quizRepository.findById(quizId).orElse(null);
		Attempt a = new Attempt();
		a.setUser(user);
		a.setQuiz(quiz);
		a.setAttemptAt(LocalDateTime.now());
		a.setTotal(quiz.getQuestion()==null ? 0 :quiz.getQuestion().size());
		a.setScore(0);
		return attemptRepository.save(a);
	}

	@Override
	public Map<String, Object> answerQuestion(Long attemptId, Long questionId, List<Long> selectedOptionIds) {
		// TODO Auto-generated method stub
		Attempt attempt = attemptRepository.findById(attemptId).orElse(null);
		Question question = questionRepository.findById(questionId).orElse(null);
		HashMap<String, Object> result = new HashMap<>();
		if(attempt==null || question==null) {
			result.put("error", "Invalid attempt or question");
			return result;
		}
		
		List<Option> correctOptions = question.getOption().stream().filter(Option::isCorrect).collect(Collectors.toList());
		Set<Long> correctIds = correctOptions.stream().map(Option::getId).collect(Collectors.toSet());
		Set<Long> selected;
		if (selectedOptionIds == null) {
		    selected = Collections.emptySet();
		} else {
		    selected = new HashSet<>(selectedOptionIds);
		}
		boolean correct = selected.equals(correctIds);
		
		
		// save AttemptAnswer
		AttemptAnswer aa = new AttemptAnswer();
		aa.setAttempt(attempt);
		aa.setQuestion(question);
		aa.setSelectedOptionIds(selected.stream().map(String::valueOf).collect(Collectors.joining(",")));
		aa.setCorrect(correct);
		attemptAnswerRepository.save(aa);
		
		
		//update attempt score if correct
		if (correct) {
			attempt.setScore(attempt.getScore()+1);
		}
		
		attemptRepository.save(attempt);
		result.put("correct", correct);
		result.put("correctOptionIds", correctIds);
		result.put("aatemptId", attempt.getId());
		return result;
	}

	@Override
	public Attempt findById(Long id) {
		// TODO Auto-generated method stub
		return attemptRepository.findById(id).orElse(null);
	}

}
