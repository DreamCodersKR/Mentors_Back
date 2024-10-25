package com.dream.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Tb_feedback")
public class Tb_Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id")
    private int feedbackId;

    @ManyToOne
    @JoinColumn(name = "counsel_id", nullable = false)
    private Tb_Counsel counsel;

    @Column(name = "ftb_content", length = 500)
    private String content;
}
