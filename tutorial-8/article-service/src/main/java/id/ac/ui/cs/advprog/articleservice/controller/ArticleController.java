package id.ac.ui.cs.advprog.articleservice.controller;

import id.ac.ui.cs.advprog.articleservice.model.Article;
import id.ac.ui.cs.advprog.articleservice.model.dto.CreateArticleDTO;
import id.ac.ui.cs.advprog.articleservice.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/article")
public class ArticleController {
    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService){
        this.articleService = articleService;
    }

    @GetMapping(path = "/get-all-posts")
    public ResponseEntity<List<Article>> getAllArticles() {
        return ResponseEntity.ok(articleService.getAllArticles());
    }

    @GetMapping(path = "/get-post/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable Integer id) {
        return ResponseEntity.ok(articleService.findArticleById(id));
    }

    @PostMapping(path = "/create-post")
    public ResponseEntity<Article> createArticle(@RequestBody CreateArticleDTO createArticleDTO) {
        return ResponseEntity.ok(articleService.createArticle(createArticleDTO));
    }

    @DeleteMapping(path = "/delete-post/{id}")
    public ResponseEntity<String> deleteArticle(@PathVariable Integer id) {
        articleService.deleteArticle(id);
        return ResponseEntity.ok(String.format("Deleted Article with id %d", id));
    }
}
