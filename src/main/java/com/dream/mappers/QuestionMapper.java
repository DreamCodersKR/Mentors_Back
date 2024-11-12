package com.dream.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.dream.entity.Tb_Question;

import java.util.List;

@Mapper
public interface QuestionMapper {
    List<Tb_Question> getQuestionsByCategory(@Param("categoryIdx") int categoryIdx, @Param("mentorYn") char mentorYn);
}
