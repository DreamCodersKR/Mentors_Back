package com.dream.entity;
import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "tb_comment")
@Data
@NoArgsConstructor
public class Tb_Comment {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "comment_idx", nullable = false)
	    private Integer commentIdx;

	    @ManyToOne
	    @JoinColumn(name = "board_idx", nullable = false)
	    @ToString.Exclude
	    private Tb_Board board;

	    @Column(name = "user_email", nullable = false)
	    private String userEmail;

	    @Column(name = "comment_content", length = 900, nullable = false)
	    private String commentContent;

	    @Column(name = "comment_date", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	    private LocalDateTime commentDate;
	    
	    @Transient
	    private String userNickname;
	    @Transient
	    private Integer boardIdx;
	    
	    public void setBoardIdx(Integer boardIdx) {
	        this.boardIdx = boardIdx;
	        if (this.board == null) {
	            this.board = new Tb_Board();
	        }
	        this.board.setBoardIdx(boardIdx);
	    }
}


