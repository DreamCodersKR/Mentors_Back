package com.dream.service;

import com.dream.entity.Tb_Question;
import com.dream.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Tb_Question> getQuestionsByCategory(Integer categoryIdx) {
    	System.out.println("값제데로 호출되고있나??" + questionRepository.findByCategory_CategoryIdx(categoryIdx));
        return questionRepository.findByCategory_CategoryIdx(categoryIdx);
    }
}
