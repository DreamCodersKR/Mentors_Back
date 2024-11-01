package com.dream.entity;

import java.sql.Date;
import java.sql.Timestamp;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Tb_User")
public class Tb_User {
	  	@Id
	    @Column(name = "user_id", length = 50)
	    private String memberId;

	    @Column(name = "user_pw", nullable = false, length = 50)
	    private String password;

	    @Column(name = "user_name", nullable = false, length = 10)
	    private String name;

	    @Column(name = "user_gender", nullable = false, length = 1)
	    private String gender;

	    @Column(name = "user_birth")
	    private Date birthdate;

	    @Column(name = "user_email", length = 50)
	    private String email;

	    @Column(name = "user_cate", length = 10)
	    private String memberType;

	    @Column(name = "user_del", length = 1)
	    private String deleted;

	    @Column(name = "user_notice", length = 1)
	    private String noticeAgree;

	    @Column(name = "user_create")
	    private Timestamp createDate;

}


