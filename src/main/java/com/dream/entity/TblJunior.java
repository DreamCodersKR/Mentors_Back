package com.dream.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Tb_junior")
public class TblJunior {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jun_id")
    private int juniorId;

    @ManyToOne
    @JoinColumn(name = "mem_id", nullable = false)
    private TblMember member;
}
