package com.example.quizapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.quizapp.entity.Quiz;
import com.example.quizapp.service.QuizService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private QuizService quizService;
	
	@GetMapping("/quizzes")
	public String listQuizzes(Model model) {
		model.addAttribute("quizzes", quizService.findAll());
		return "admin/quizzes";
	}
	
	@GetMapping("/quizzes/create")
	public String createQuizForm(Model model) {
		model.addAttribute("quiz", new Quiz());
		return"admin/create-quiz";
	}
	
	@PostMapping("/quizzes/create")
	public String createQuizSubmit(@ModelAttribute Quiz quiz) {
		quizService.save(quiz);
		return "redirect:/admin/quizzes";
	}
	
	@PostMapping("/quizzes/delete/{id}")
	public String quizDelete(@PathVariable Long id) {
		quizService.deleteById(id);
		return "redirect:/admin/quizzes";
	}

}
