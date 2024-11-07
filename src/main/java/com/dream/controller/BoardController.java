package com.dream.controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dream.entity.Tb_Board;
import com.dream.service.BoardService;

import jakarta.servlet.http.HttpSession;

@RestController
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@PostMapping("/writeBoard")
	public ResponseEntity<Map<String, Object>> writeBoard(@RequestBody Tb_Board board,HttpSession session) {
		
		String userEmail = (String)session.getAttribute("userEmail");
		board.setUserEmail(userEmail);
		 
		ResponseEntity<Map<String, Object>>writeResult = boardService.writeBoard(board);
		
		
	
		
		return writeResult;
	}
}
