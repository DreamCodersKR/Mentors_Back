package com.dream.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Tb_mentors_review")
public class TblMentorsReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mentor_rev_id")
    private int mentorRevId;

    @ManyToOne
    @JoinColumn(name = "mem_id", nullable = false)
    private TblMember member;

    @Column(name = "mentor_rat")
    private int rating;

    @Column(name = "review_con", length = 500)
    private String reviewContent;

    @Column(name = "reviewer", length = 50)
    private String reviewer;
}
