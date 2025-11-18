package com.example.quizapp.service;

import java.util.Collections;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.quizapp.entity.User;
import com.example.quizapp.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public User register(User user) {
		// TODO Auto-generated method stub
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		// default role
		user.setRoles(new HashSet<>(Collections.singletonList("ROLE_USER")));
		return userRepository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username).orElse(null);
	}

}
