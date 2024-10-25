package com.dream.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Tb_address")
public class Tb_Address {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "address_id")
	    private int addressId;

	    @ManyToOne
	    @JoinColumn(name = "mem_id", nullable = false)
	    private Tb_Member member;

	    @Column(name = "land_name", length = 50)
	    private String landName;

	    @Column(name = "zip_code")
	    private int zipCode;

	    @Column(name = "address", length = 100)
	    private String address;

	    @Column(name = "detail", length = 100)
	    private String detail;

}
