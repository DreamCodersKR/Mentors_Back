package com.dream.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Tb_profile")
public class Tb_Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private int profileId;

    @ManyToOne
    @JoinColumn(name = "mem_id", nullable = false)
    private Tb_Member member;

    @Column(name = "mem_major", length = 50)
    private String major;
}
