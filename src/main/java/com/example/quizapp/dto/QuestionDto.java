package com.example.quizapp.dto;

import lombok.Data;

@Data
public class QuestionDto {

	private Long id;
	private String text;
	private boolean multiple;
}
