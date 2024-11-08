package com.dream.entity;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "tb_board")
@Data
@NoArgsConstructor
public class Tb_Board {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_idx", nullable = false)
    private Integer boardIdx;

    @ManyToOne
    @JoinColumn(name = "user_email", nullable = false)
    @JsonIgnore
    private Tb_User user;

    @Column(name = "board_title", length = 1000, nullable = false)
    private String boardTitle;

    @Column(name = "board_content", nullable = false, columnDefinition = "TEXT")
    private String boardContent;

    @Column(name = "board_write_dt", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime boardWriteDt;

    @Column(name = "board_views", nullable = false)
    private int boardViews = 0;

    @Column(name = "board_likes", nullable = false)
    private int boardLikes = 0;
    
    @Column(name = "board_delYn", nullable = false)
    private String boardDelYn ="N";
    
    // 필드이외에 전달되는 값
    @Transient
    private String userEmail;
    @Transient
    private String userNickname;
    @Transient
    private int commentCount;
    
    
}
