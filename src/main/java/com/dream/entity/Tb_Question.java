package com.dream.entity;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;
@Entity
@Table(name = "tb_question")
@Data
@NoArgsConstructor
public class Tb_Question {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "question_idx", nullable = false)
	    private Integer questionIdx;

	    @ManyToOne
	    @JoinColumn(name = "category_idx", nullable = false)
	    private Tb_Category category;

	    @Column(name = "question_content", nullable = false, columnDefinition = "TEXT")
	    private String questionContent;
}
