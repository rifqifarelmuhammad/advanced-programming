package id.ac.ui.cs.advprog.commentservice.dto;

import jakarta.persistence.Column;
import lombok.Data;
import java.sql.Timestamp;

@Data
public class ArticleResponse {
    private String author;
    private String title;
    @Column(columnDefinition="TEXT")
    private String content;
    private Timestamp timestamp;
}
