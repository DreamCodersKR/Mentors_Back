package com.dream.entity;

import java.sql.Date;
import java.sql.Timestamp;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Tb_member")
public class Tb_Member {
	  	@Id
	    @Column(name = "mem_id", length = 50)
	    private String memberId;

	    @Column(name = "mem_pw", nullable = false, length = 50)
	    private String password;

	    @Column(name = "mem_name", nullable = false, length = 10)
	    private String name;

	    @Column(name = "mem_gender", nullable = false, length = 1)
	    private String gender;

	    @Column(name = "mem_birth")
	    private Date birthDate;

	    @Column(name = "mem_email", length = 50)
	    private String email;

	    @Column(name = "mem_cate", length = 10)
	    private String memberType;

	    @Column(name = "mem_date")
	    private Date joinDate;

	    @Column(name = "mem_del", length = 1)
	    private String deleted;

	    @Column(name = "mem_notice", length = 1)
	    private String noticeAgree;

	    @Column(name = "mem_create")
	    private Timestamp createDate;

}


