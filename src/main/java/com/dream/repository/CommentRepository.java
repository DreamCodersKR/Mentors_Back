package com.dream.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dream.entity.Tb_Board;
import com.dream.entity.Tb_Comment;

@Repository
public interface CommentRepository extends JpaRepository<Tb_Comment, Integer> {

}
