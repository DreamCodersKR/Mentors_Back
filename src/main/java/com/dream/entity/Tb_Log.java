package com.dream.entity;
import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Set;
@Data
@Entity
@Table(name = "tb_log")
@NoArgsConstructor
public class Tb_Log {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_idx", nullable = false)
    private Integer logIdx;

    @ManyToOne
    @JoinColumn(name = "user_email", nullable = false)
    private Tb_User user;

    @Column(name = "log_type", length = 10, nullable = false)
    private String logType;

    @Column(name = "log_time", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime logTime;
}
