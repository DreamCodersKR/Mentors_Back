package com.dream.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dream.entity.Tb_Comment;
import com.dream.service.CommentService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/comments")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping("/add")
	public ResponseEntity<Map<String, Object>> addComment(@RequestBody Tb_Comment comment, HttpSession session) {
		String userEmail = (String) session.getAttribute("userEmail");
		
		if(userEmail == null) {
			Map<String, Object> response = new HashMap<>();
			response.put("status", "fail");
			response.put("message", "로그인이 필요합니다.");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
		}
		
		comment.setUserEmail(userEmail);
		Map<String, Object> result = commentService.addComment(comment);
		if(result.get("status").equals("success")) {
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
		}
	}
	
	@GetMapping("/{boardIdx}")
	public ResponseEntity<List<Tb_Comment>> getComments(@PathVariable("boardIdx") int boardIdx) {
		List<Tb_Comment> comments = commentService.getCommentsByBoardIdx(boardIdx);
		if(comments != null && !comments.isEmpty()) {
			return ResponseEntity.ok(comments);
		} else {
			return ResponseEntity.noContent().build();
		}
		
	}
	
}
