package com.example.quizapp.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Attempt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private User user;
	@ManyToOne
	private Quiz quiz;
	
	private int score;
	private int total;
	
	private LocalDateTime attemptAt;
	
	@OneToMany(mappedBy = "attempt", cascade = CascadeType.ALL)
	private List<AttemptAnswer> answer;
	
	
}
