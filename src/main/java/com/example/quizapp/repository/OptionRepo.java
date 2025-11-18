package com.example.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quizapp.entity.Option;

public interface OptionRepo extends JpaRepository<Option, Long> {
	

}
