package com.dream.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Tb_act")
public class TblAct {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "act_id")
    private int activityId;

    @ManyToOne
    @JoinColumn(name = "mem_id", nullable = false)
    private TblMember member;
}
