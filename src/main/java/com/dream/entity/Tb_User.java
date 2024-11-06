package com.dream.entity;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_user")
@Data
@NoArgsConstructor
public class Tb_User {


    @Id
    @Column(name = "user_email", length = 50, nullable = false)
    private String email;

    @Column(name = "user_pw", length = 255, nullable = false)
    private String password;

    @Column(name = "user_gender", length = 1, nullable = false)
    private String gender;
    
    @Column(name = "user_name", length = 50, nullable = false)
    private String name;
    
    @Column(name = "user_nickname", length = 50, nullable = false)
    private String nickName;
    
    @Column(name = "user_birthdate", nullable = false)
    private Date birthDate;

    @Column(name = "user_del", length = 1, nullable = false)
    private String userDel = "N";

    @Column(name = "user_notice", length = 1, nullable = false)
    private String userNotice = "N";

    @Column(name = "user_create", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime userCreate;

    @Column(name = "user_category", length = 10, nullable = false)
    private String userCategory;

    @Column(name = "premium_yn", length = 1, nullable = false)
    private String premiumYn = "N";

    @Column(name = "mentor_yn", length = 1, nullable = false)
    private String mentorYn;

    @Column(name = "user_profile_file", length = 1000)
    private String userProfileFile;
    
    @Transient
    private String confirmPassword;
    
    @Transient
    private boolean passwordMismatch;
}
