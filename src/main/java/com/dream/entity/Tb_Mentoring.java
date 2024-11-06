package com.dream.entity;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Set;
@Entity
@Table(name = "tb_mentoring")
@Data
@NoArgsConstructor
public class Tb_Mentoring {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mentoring_idx", nullable = false)
    private Integer mentoringIdx;

    @Column(name = "talker", length = 50, nullable = false)
    private String talker;

    @Column(name = "talk_content", columnDefinition = "TEXT")
    private String talkContent;

    @Column(name = "talk_emoticon", length = 1000)
    private String talkEmoticon;

    @Column(name = "talk_file", length = 1000)
    private String talkFile;

    @Column(name = "talk_time", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime talkTime;

    @ManyToOne
    @JoinColumn(name = "mroom_idx", nullable = false)
    private Tb_Mentoring_Room mentoringRoom;
}
