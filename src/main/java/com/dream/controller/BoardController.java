package com.dream.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dream.entity.Tb_Board;
import com.dream.entity.Tb_Comment;
import com.dream.repository.BoardRepository;
import com.dream.service.BoardService;


import jakarta.servlet.http.HttpSession;

@RestController
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	BoardRepository boardRepo;
	
	@PostMapping("/writeBoard")
	public ResponseEntity<Map<String, Object>> writeBoard(@RequestBody Tb_Board board,HttpSession session) {
		
		String userEmail = (String)session.getAttribute("userEmail");
		
		board.setUserEmail(userEmail);
		 
		ResponseEntity<Map<String, Object>>writeResult = boardService.writeBoard(board);
		
		return writeResult;
	}
	

	// 게시글 전체 조회
	@GetMapping("/boardList")
	public ResponseEntity<List<Tb_Board>> getBoardList() {
		List<Tb_Board> boardList = boardService.getBoardList();
//		System.out.println(boardList);
		List<Tb_Board> filteredBoardList = boardList.stream()
			    .filter(board -> !"Y".equals(board.getBoardDelYn()))
			    .collect(Collectors.toList());
		return ResponseEntity.ok(filteredBoardList);
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
	
	//게시물 삭제
	@GetMapping("/boardDelete/{id}")
	public ResponseEntity<Map<String, Object>> boardDelete(@PathVariable("id") Integer boardIdx){
		Tb_Board board = boardService.getBoardDetail(boardIdx);
		board.setBoardDelYn("Y");
		ResponseEntity<Map<String, Object>> delResult = boardService.DeleteBoard(board);
		
		return delResult;
	}
	
	// 게시물 조회
	@GetMapping("/boardSearch/{search}")
	public ResponseEntity<List<Tb_Board>> searchBoard(@PathVariable("search") String searchValue) {
		searchValue = "%"+searchValue+"%";
		List<Tb_Board> list = boardService.getSearchBoardList(searchValue);
//		System.out.println(list);
		List<Tb_Board> filteredBoardList = list.stream()
			    .filter(board -> !"Y".equals(board.getBoardDelYn()))
			    .collect(Collectors.toList());
//		System.out.println(filteredBoardList);
		return ResponseEntity.ok(filteredBoardList);	
	}
	
	// 게시글 좋아요
	@PostMapping("/board/like/{boardIdx}")
	public ResponseEntity<Map<String, Object>> likeBoard(@PathVariable("boardIdx") Integer boardIdx) {
		boolean success = boardService.incrementLikes(boardIdx);
		
		Map<String, Object> response = new HashMap<>();
		
		if (success) {
			int updatedLikes = boardRepo.findById(boardIdx).get().getBoardLikes(); 
	        response.put("message", "좋아요가 반영되었습니다.");
	        response.put("updatedLikes", updatedLikes); 
	        return ResponseEntity.ok(response); 
        } else {
        	response.put("message", "게시글을 찾을 수 없습니다.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
	}
	
	@GetMapping("/board/increase/{id}")
	public ResponseEntity<Tb_Board> increaseBoardViews(@PathVariable("id") Integer boardIdx) {
	    boardService.incrementViews(boardIdx);

	    // 게시글 정보 가져오기
	    Tb_Board board = boardService.getBoardDetail(boardIdx);
	    if (board != null) {
	        return ResponseEntity.ok(board);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
}
