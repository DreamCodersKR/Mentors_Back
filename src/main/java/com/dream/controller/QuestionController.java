package com.dream.controller;

import com.dream.entity.Tb_Question;
import com.dream.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Tb_Question>> getQuestionsByCategory(
            @PathVariable("categoryId") Integer categoryId,
            @RequestParam("mentorYn") char mentorYn) { 
        List<Tb_Question> questions = questionService.getQuestionsByCategory(categoryId, mentorYn);
        if (questions != null && !questions.isEmpty()) {
            return ResponseEntity.ok(questions);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
