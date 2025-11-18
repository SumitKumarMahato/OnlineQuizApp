package com.example.quizapp.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.quizapp.entity.Attempt;
import com.example.quizapp.repository.AttemptRepo;


@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired private AttemptRepo attemptRepository;

    @GetMapping("/attempts")
    public String attempts(Model model, Principal principal) {
        List<Attempt> list = attemptRepository.findAll();
        model.addAttribute("attempts", list); 
        return "user/attempts";
    }
}
