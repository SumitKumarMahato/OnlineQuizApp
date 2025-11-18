package com.example.quizapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.quizapp.entity.User;
import com.example.quizapp.service.UserService;

@Controller
public class AuthController {

	@Autowired
	private UserService userService;
	
	@GetMapping({"/" , "/index"})
	public String home(Model model) {
		model.addAttribute("message", "Welcome to Online Quiz App");
		return "index";
	}
	
	@GetMapping("/register")
	public String registerForm(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	
	@PostMapping("/register")
	public String registerSubmit(@ModelAttribute User user, Model model) {
		if(userService.findByUsername(user.getUsername()) != null) {
			model.addAttribute("error", "Username already exits");
			return "register";
		}
		userService.register(user);
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String login() {
		
		return "login";
	}
	
}
