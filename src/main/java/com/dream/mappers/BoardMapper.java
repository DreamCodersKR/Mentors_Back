package com.dream.mappers;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.dream.entity.Tb_Board;

@Mapper
public interface BoardMapper {

	
	public Integer writeBoard(Tb_Board board);
	
	public ArrayList<Tb_Board> viewBoard(String userEmail);
}
