package com.dream.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
@Table(name = "Tb_counsel_rv")
public class TblCounselRv {
	  	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "rv_id")
	    private int reviewId;

	    @ManyToOne
	    @JoinColumn(name = "counsel_id", nullable = false)
	    private TblCounsel counsel;

	    @Column(name = "rv_date")
	    private Date reviewDate;

	    @Column(name = "rv_content", length = 100)
	    private String reviewContent;

	    @Column(name = "rv_cancel", length = 1)
	    private String cancelStatus;
}
