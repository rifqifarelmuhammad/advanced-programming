package id.ac.ui.cs.advprog.articleservice.repository;

import id.ac.ui.cs.advprog.articleservice.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
    @NonNull
    List<Article> findAll();

    @NonNull
    Article findArticleById(@NonNull Integer id);

    void deleteById(@NonNull Integer id);
}
