package id.ac.ui.cs.advprog.articleservice.service;

import id.ac.ui.cs.advprog.articleservice.model.Article;
import id.ac.ui.cs.advprog.articleservice.model.dto.CreateArticleDTO;

import java.util.List;

public interface ArticleService {
    List<Article> getAllArticles();
    Article findArticleById(Integer id);
    Article createArticle(CreateArticleDTO request);
    void deleteArticle(Integer id);
}
