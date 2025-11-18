package com.example.quizapp.service;

import com.example.quizapp.entity.User;

public interface UserService {

	User register(User user);
	User findByUsername(String username);
}
