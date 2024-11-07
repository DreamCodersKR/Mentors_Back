package com.dream.mappers;

import org.apache.ibatis.annotations.Mapper;

import com.dream.entity.Tb_Board;

@Mapper
public interface BoardMapper {

	
	public Integer writeBoard(Tb_Board board);
}
