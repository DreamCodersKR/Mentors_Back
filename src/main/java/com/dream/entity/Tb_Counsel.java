package com.dream.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
@Table(name = "Tb_counsel")
public class Tb_Counsel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "counsel_id")
    private int counselId;

    @ManyToOne
    @JoinColumn(name = "jun_id", nullable = false)
    private Tb_Junior junior;

    @ManyToOne
    @JoinColumn(name = "sen_id", nullable = false)
    private Tb_Senior senior;

    @Column(name = "counsel_date")
    private Date counselDate;

    @Column(name = "counsel_code", length = 10)
    private String counselCode;

    @Column(name = "counsel_prog", length = 1)
    private String counselProgress;

    @Column(name = "rv_status", length = 1)
    private String reservationStatus;
}
