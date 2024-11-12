package com.dream.entity;
import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Set;
@Entity
@Table(name = "tb_bios_detail")
@Data
@NoArgsConstructor
public class Tb_Bios_Detail {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_idx", nullable = false)
    private Integer detailId;

    @ManyToOne
    @JoinColumn(name = "bios_idx", nullable = false)
    private Tb_Bios bios;

    @ManyToOne
    @JoinColumn(name = "question_idx", nullable = false)
    private Tb_Question question;

    @Column(name = "detail_content", nullable = false, columnDefinition = "TEXT")
    private String detailContent;
    
    @Column(name = "bios_title", length = 500, nullable = false)
    private String biosTitle;
    
    @Column(name = "parent_category_id", nullable = false)
    private Integer parentCategoryId;
    
    @Column(name = "sub_category_name", length = 100, nullable = false)
    private String subCategoryName;

    @Column(name = "detail_date", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime detailDate;
    
    @Transient
    private int biosIdx;
    
    @Transient
    private int questionIdx;
    
}
