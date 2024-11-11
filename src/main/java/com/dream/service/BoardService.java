package com.dream.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dream.entity.Tb_Board;
import com.dream.mappers.BoardMapper;
import com.dream.repository.BoardRepository;
import com.dream.repository.UserRepository;

@Service
@Transactional
public class BoardService {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	BoardRepository boardRepo;
	
	@Autowired
	BoardMapper boardMapper;
	
	//게시물 작성(DB등록)
	public ResponseEntity<Map<String, Object>> writeBoard(Tb_Board board) {
		
		 Integer row = boardMapper.writeBoard(board);
		 Map<String, Object> result = new HashMap<>();
		 if(row != null) {
			 result.put("message", "게시물작성 성공");
			 return ResponseEntity.ok(result);
		 }else{
			 result.put("message", "게시물 작성 실패");
			 return ResponseEntity.ok(result);
		 }
	}

	// 글 목록 조회 
	public List<Tb_Board> getBoardList() {
		return boardMapper.selectAllBoards();
	}
	
	// 게시글 상세 목록 조회
	public Tb_Board getBoardDetail(Integer boardIdx) {
		return boardRepo.findById(boardIdx).orElse(null);
	}
	
	// 댓글 목록 조회
	public Tb_Board getCommentDetail(Integer boardIdx) {
		return boardRepo.findById(boardIdx).orElse(null);
	}
	
	// 게시물 삭제
	public ResponseEntity<Map<String, Object>> DeleteBoard(Tb_Board board){
		Map<String, Object> result = new HashMap<>();
		boardRepo.save(board);
		if(board.getBoardDelYn().equals("Y")) {
			result.put("message", "게시물삭제 성공");
			return ResponseEntity.ok(result);
		}else {
			result.put("message", "게시물삭제 실패");
			return ResponseEntity.ok(result);
		}
	}
	
	// 게시물 검색(조회)
	public List<Tb_Board> getSearchBoardList(String searchValue) {
		return boardMapper.searchBoard(searchValue);
	}
	
	@Transactional
	public boolean incrementLikes (Integer boardIdx) {
		int updateRows = boardMapper.incrementLikes(boardIdx);
	    return updateRows > 0;
	}
	
}
