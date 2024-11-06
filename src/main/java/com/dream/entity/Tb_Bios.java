package com.dream.entity;
import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Set;
@Entity
@Table(name = "tb_bios")
@Data
@NoArgsConstructor
public class Tb_Bios {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "bios_idx", nullable = false)
	    private Integer biosIdx;

	    @Column(name = "bios_title", length = 500, nullable = false)
	    private String biosTitle;

	    @ManyToOne
	    @JoinColumn(name = "user_email", nullable = false)
	    private Tb_User user;

	    @Column(name = "bios_date", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	    private LocalDateTime biosDate;
}
