package com.dream.entity;
import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Set;
@Entity
@Table(name = "tb_file")
@Data
@NoArgsConstructor
public class Tb_File {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_idx", nullable = false)
    private Integer fileIdx;

    @ManyToOne
    @JoinColumn(name = "board_idx", nullable = false)
    private Tb_Board board;

    @Column(name = "file_rname", length = 1000, nullable = false)
    private String fileRname;

    @Column(name = "file_size", nullable = false)
    private Long fileSize;

    @Column(name = "file_type", length = 10, nullable = false)
    private String fileType;

    @Column(name = "upload_date", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime uploadDate;
}
