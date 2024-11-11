package com.dream.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dream.entity.Tb_Board;


@Repository
public interface BoardRepository extends JpaRepository<Tb_Board, Integer> {
	
//	@Modifying  // JPA로 구현해보려했으나 파라미터가 제데로 mapping이 되지않아 미해결
//	@Query(value = "UPDATE tb_board SET board_likes = board_likes + 1 WHERE board_idx = :boardIdx", nativeQuery = true)
//	int incrementLikes(@Param("boardIdx") Integer boardIdx);

}
