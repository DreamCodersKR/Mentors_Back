package com.dream.controller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dream.entity.Tb_Board;
import com.dream.entity.Tb_Comment;
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
	
	// 게시글 상세보기 조회
	@GetMapping("/boardDetail/{id}")
	public ResponseEntity<Tb_Board> getBoardDetail(@PathVariable("id") Integer boardIdx) {
		Tb_Board board = boardService.getBoardDetail(boardIdx);
		
		if(board != null) {
			return ResponseEntity.ok(board);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
