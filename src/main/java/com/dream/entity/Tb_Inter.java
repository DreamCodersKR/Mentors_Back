package com.dream.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Tb_inter")
public class Tb_Inter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inter_id")
    private int interestId;

    @ManyToOne
    @JoinColumn(name = "mem_id", nullable = false)
    private Tb_Member member;

    @Column(name = "inter_cate", length = 100)
    private String interestCategory;
}
