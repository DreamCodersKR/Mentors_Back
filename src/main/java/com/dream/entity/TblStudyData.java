package com.dream.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "Tb_study_data")
public class TblStudyData {
	   	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "data_id")
	    private int dataId;

	    @ManyToOne
	    @JoinColumn(name = "counsel_id", nullable = false)
	    private TblCounsel counsel;

	    @Column(name = "up_date")
	    private Timestamp uploadDate;
}
