package id.ac.ui.cs.advprog.articleservice.service;

import id.ac.ui.cs.advprog.articleservice.model.Article;
import id.ac.ui.cs.advprog.articleservice.model.dto.CreateArticleDTO;
import id.ac.ui.cs.advprog.articleservice.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{

    private final ArticleRepository articleRepository;
    private final RestTemplate restTemplate;
    private final String otherInstanceURL = "http://localhost:8081/api/v1/comment/";

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository, RestTemplate restTemplate) {
        this.articleRepository = articleRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public Article findArticleById(Integer id) {
        return articleRepository.findArticleById(id);
    }

    @Override
    public Article createArticle(CreateArticleDTO request) {
        Article article = Article.builder()
                .author(request.getAuthor())
                .title(request.getTitle())
                .content(request.getContent())
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .build();
        return this.articleRepository.save(article);
    }

    @Override
    public void deleteArticle(Integer id) {
        articleRepository.deleteById(id);
        restTemplate.delete(otherInstanceURL + "delete-all-comment/" + id);
    }
}
