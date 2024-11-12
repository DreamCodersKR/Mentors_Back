package com.dream.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dream.dto.ResponseDto;
import com.dream.service.ResponseService;

@RestController
@RequestMapping("/responses")
public class ResponseController {
	
	@Autowired
	private ResponseService responseService;
	
	@PostMapping("/add")
	public ResponseEntity<String> saveResponse(@RequestBody ResponseDto responseDto) {
		try {
			System.out.println("요청받은 데이터 : " + responseDto);
			responseService.saveResponse(responseDto);
			return ResponseEntity.ok("Response saved successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save response.");
		}
	}
	
}
