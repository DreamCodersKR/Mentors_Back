package com.dream.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dream.entity.Tb_Comment;

@Mapper
public interface CommentMapper {
	
	int insertComment(Tb_Comment comment);
	List<Tb_Comment> selectCommentsByBoardIdx(int boardIdx);
	
}
