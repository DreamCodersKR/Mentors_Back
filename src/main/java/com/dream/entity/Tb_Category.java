package com.dream.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tb_Question> questions; // 질문 리스트와의 연관
}
