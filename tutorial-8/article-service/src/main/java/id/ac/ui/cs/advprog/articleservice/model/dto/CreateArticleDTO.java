package id.ac.ui.cs.advprog.articleservice.model.dto;

import lombok.Data;

@Data
public class CreateArticleDTO {
    String author;
    String title;
    String content;
}
