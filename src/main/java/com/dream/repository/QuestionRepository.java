package com.dream.repository;

import com.dream.entity.Tb_Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Tb_Question, Integer> {
    List<Tb_Question> findByCategory_CategoryIdx(Integer categoryIdx);
}
