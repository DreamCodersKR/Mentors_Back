package com.dream.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {
	
	private String userEmail;
	private String responseType;
	private List<QuestionDetailDto> questions;
	
}
