package com.example.quizapp.dto;

import lombok.Data;

@Data
public class OptionDto {

	private Long id;
	private String text;
	private boolean correct;
}
