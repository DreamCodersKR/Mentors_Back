package com.dream.entity;
import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Set;
@Entity
@Table(name = "tb_notification")
@Data
@NoArgsConstructor
public class Tb_Notification {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_idx", nullable = false)
    private Integer notificationIdx;

    @ManyToOne
    @JoinColumn(name = "user_email", nullable = false)
    private Tb_User user;

    @Column(name = "alarm_content", length = 50, nullable = false)
    private String alarmContent;

    @Column(name = "alarm_type", length = 30, nullable = false)
    private String alarmType;

    @Column(name = "is_read", nullable = false)
    private Boolean isRead = false;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;

    @Column(name = "create_date", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createDate;
}
