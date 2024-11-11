package com.dream.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_question")
@Data
@NoArgsConstructor
public class Tb_Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_idx", nullable = false)
    private Integer questionIdx;

    @ManyToOne
    @JoinColumn(name = "category_idx", nullable = false)
    private Tb_Category category; // 연관된 카테고리

    @Column(name = "question_content", nullable = false, columnDefinition = "TEXT")
    private String questionContent;

    @Column(name = "placeholder", columnDefinition = "TEXT")
    private String placeholder;

    @Column(name = "mentor_yn", nullable = false, length = 1)
    private char mentorYn; // 멘토 여부
}
