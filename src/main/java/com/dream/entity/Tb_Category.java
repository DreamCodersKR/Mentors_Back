package com.dream.entity;
import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "tb_category")
@Data
@NoArgsConstructor
public class Tb_Category {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_idx", nullable = false)
    private Integer categoryIdx;

    @Column(name = "category_name", length = 100, nullable = false)
    private String categoryName;

    @ManyToOne
    @JoinColumn(name = "super_category")
    private Tb_Category superCategory;
}