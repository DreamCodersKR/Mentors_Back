package com.dream.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dream.entity.Tb_Board;

import jakarta.servlet.http.HttpSession;

@RestController
public class BoardController {
	
	
	@PostMapping("/writeBoard")
	public ResponseEntity<Map<String, Object>> writeBoard(@RequestBody Tb_Board board,HttpSession session) {
		Map<String, Object> result = new HashMap<>();
		System.out.println(board);
		result.put("test", "test");
		
		return ResponseEntity.ok(result);
	}
}
