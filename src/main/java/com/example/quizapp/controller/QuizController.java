package com.example.quizapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.quizapp.entity.Attempt;
import com.example.quizapp.entity.Quiz;
import com.example.quizapp.service.AttemptService;
import com.example.quizapp.service.AttemptServiceImpl;
import com.example.quizapp.service.QuizService;

@Controller
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	private QuizService quizService;
	@Autowired
	private AttemptService attemptService;
	
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("quizzes", quizService.findAll());
		return "quiz/list"; 
	}
	
	@PostMapping("/start/{quizId}")
	public String start(@PathVariable Long quizId, Authentication auth) {
		String username = auth.getName();
		Attempt a = attemptService.startAttempt(username, quizId);
		if(a==null)
			return "redirect:/quiz/list";
		
		//redirect to take page
		return "redirect:/quiz/take" +a.getId() +"/" +quizId;
	}
	
	@GetMapping("/take/{attemptId}/{quizId}")
	public String take(@PathVariable Long attempId, @PathVariable Long quizId, Model model) {
		Quiz q = quizService.findById(quizId);
		model.addAttribute("quiz", q);
		model.addAttribute("attemptId", attempId);
		
		return "quiz/take";
	}
	
	@GetMapping("/result/{attemptId}")
	public String showResult(@PathVariable Long attemptId, Model model) {
		Attempt a = attemptService.findById(attemptId);
		if(a==null)
			return "redirect:/quiz/list";
		model.addAttribute("attempt", a);
		return "quiz/result"; 
	}
	
	
	
}
