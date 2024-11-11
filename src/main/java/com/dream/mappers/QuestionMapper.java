package com.dream.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.dream.entity.Tb_Question;

@Mapper
public interface QuestionMapper {
    List<Tb_Question> getQuestionsByCategory(@Param("categoryIdx") int categoryIdx, @Param("mentorYn") char mentorYn);
}
