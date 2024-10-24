package com.dream.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Tb_tracking")
public class TblTracking {
	  	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "tarck_id")
	    private int trackingId;

	    @ManyToOne
	    @JoinColumn(name = "mem_id", nullable = false)
	    private TblMember member;
}
