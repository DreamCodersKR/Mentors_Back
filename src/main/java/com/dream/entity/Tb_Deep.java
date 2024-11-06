package com.dream.entity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Set;
@Entity
@Table(name = "tb_deep")
@Data
@NoArgsConstructor
public class Tb_Deep {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deep_idx", nullable = false)
    private Integer deepIdx;

    @Column(name = "deep_model", length = 100, nullable = false)
    private String deepModel;

    @Column(name = "deep_result", columnDefinition = "MEDIUMTEXT", nullable = false)
    private String deepResult;

    @Column(name = "deep_prediction", precision = 12, scale = 6, nullable = false)
    private BigDecimal deepPrediction;

    @Column(name = "deep_date", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime deepDate;

    @ManyToOne
    @JoinColumn(name = "bios_idx", nullable = false)
    private Tb_Bios bios;
}
