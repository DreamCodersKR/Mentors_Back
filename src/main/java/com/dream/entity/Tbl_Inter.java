package com.dream.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tbl_inter")
public class Tbl_Inter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inter_id")
    private int interestId;

    @ManyToOne
    @JoinColumn(name = "mem_id", nullable = false)
    private TblMember member;

    @Column(name = "inter_cate", length = 100)
    private String interestCategory;
}
