package com.dream.entity;
import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Set;
@Entity
@Table(name = "tb_token")
@Data
@NoArgsConstructor
public class Tb_Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "token_idx", nullable = false)
    private Integer tokenIdx;

    @ManyToOne
    @JoinColumn(name = "user_email", nullable = false)
    private Tb_User user;

    @Column(name = "user_token", length = 300, nullable = false)
    private String userToken;

    @Column(name = "expire_date", nullable = false)
    private LocalDateTime expireDate;

    @Column(name = "issue_date", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime issueDate;
}
