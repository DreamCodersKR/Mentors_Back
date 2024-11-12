package com.dream.service;

import com.dream.entity.Tb_Question;
import com.dream.mappers.QuestionMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private final QuestionMapper questionMapper;

    public QuestionService(QuestionMapper questionMapper) {
        this.questionMapper = questionMapper;
    }

    public List<Tb_Question> getQuestionsByCategory(Integer categoryIdx, char mentorYn) {
        System.out.println("카테고리 ID: " + categoryIdx + ", 멘토 여부: " + mentorYn);
        List<Tb_Question> results = questionMapper.getQuestionsByCategory(categoryIdx, mentorYn);
        results.forEach(question -> System.out.println("질문 내용: " + question));
        return results;
    }
}
