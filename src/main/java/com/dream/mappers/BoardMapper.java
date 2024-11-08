package com.dream.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dream.entity.Tb_Board;

@Mapper
public interface BoardMapper {
	
	public Integer writeBoard(Tb_Board board);
	
	List<Tb_Board> selectAllBoards();
	
	
}
