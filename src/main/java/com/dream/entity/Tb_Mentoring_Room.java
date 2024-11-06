package com.dream.entity;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Set;
@Entity
@Table(name = "tb_mentoring_room")
@Data
@NoArgsConstructor
public class Tb_Mentoring_Room {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mroom_idx", nullable = false)
    private Integer mroomIdx;

    @Column(name = "mroom_title", length = 1000, nullable = false)
    private String mroomTitle;

    @Column(name = "mroom_info", nullable = false, columnDefinition = "TEXT")
    private String mroomInfo;

    @ManyToOne
    @JoinColumn(name = "user_email", nullable = false)
    private Tb_User user;

    @Column(name = "mroom_limit", nullable = false)
    private Integer mroomLimit = 0;

    @Column(name = "mroom_status", length = 20, nullable = false)
    private String mroomStatus;

    @Column(name = "mroom_date", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime mroomDate;
    
    @OneToMany(mappedBy = "mentoringRoom", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Tb_Mentoring> mentorings;
}
