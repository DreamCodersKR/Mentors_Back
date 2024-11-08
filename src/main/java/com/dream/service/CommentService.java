package com.dream.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dream.entity.Tb_Comment;
import com.dream.mappers.CommentMapper;
import com.dream.repository.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentMapper commentMapper;
	
	@Autowired
	private CommentRepository commentRepo;
	
	
	public Map<String, Object> addComment (Tb_Comment comment) {
		Map<String, Object> response = new HashMap<>();
		
		try {
			int result = commentMapper.insertComment(comment);
			if (result > 0) {
				response.put("status", "success");
				response.put("message", "댓글이 등록되었습니다.");
			} else {
				response.put("status", "fail");
				response.put("message", "댓글 등록 실패");
			}
		} catch (Exception e) {
			System.err.println("댓글 등록 중 오류 발생: " + e.getMessage());
			response.put("status", "error");
            response.put("message", "예기치 못한 오류가 발생했습니다.");
            response.put("error", e.getMessage());
		}
		return response;
	}
	
	public List<Tb_Comment> getCommentsByBoardIdx(int boardIdx) {
		return commentMapper.selectCommentsByBoardIdx(boardIdx);
	}
	
//	댓글삭제
	public ResponseEntity<Map<String, Object>> commentDel(int commentIdx) {
		Map<String, Object> result = new HashMap<>();
		Tb_Comment comment = commentRepo.findById(commentIdx).orElse(null);
//		System.out.println(comment);
		comment.setCommentDelYn("Y");
		commentRepo.save(comment);
		if(comment.getCommentDelYn().equals("Y")) {
			result.put("message", "댓글삭제 성공");
			return ResponseEntity.ok(result);
		}else {
			result.put("message", "댓글삭제 실패");
			return ResponseEntity.ok(result);
		}
	}
	
}
