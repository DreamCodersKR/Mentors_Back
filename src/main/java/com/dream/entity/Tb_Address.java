package com.dream.entity;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;
@Entity
@Table(name = "tb_address")
@Data
@NoArgsConstructor
public class Tb_Address {

    @Id
    @Column(name = "user_email", length = 50, nullable = false)
    private String userEmail;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_email")
    private Tb_User user;

    @Column(name = "location_name", length = 50, nullable = false)
    private String locationName;

    @Column(name = "zip_code", length = 20, nullable = false)
    private String zipCode;

    @Column(name = "addr1", length = 600, nullable = false)
    private String addr1;

    @Column(name = "addr2", length = 600, nullable = false)
    private String addr2;
}
