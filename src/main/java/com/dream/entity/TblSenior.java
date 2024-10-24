package com.dream.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Tb_senior")
public class TblSenior {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sen_id")
    private int seniorId;

    @ManyToOne
    @JoinColumn(name = "mem_id", nullable = false)
    private TblMember member;
}
