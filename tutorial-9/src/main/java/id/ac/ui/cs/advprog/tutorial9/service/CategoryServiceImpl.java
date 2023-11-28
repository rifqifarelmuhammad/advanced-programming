package id.ac.ui.cs.advprog.tutorial9.service;

import id.ac.ui.cs.advprog.tutorial9.model.Article;
import id.ac.ui.cs.advprog.tutorial9.model.Category;
import id.ac.ui.cs.advprog.tutorial9.repository.ArticleRepository;
import id.ac.ui.cs.advprog.tutorial9.repository.CategoryRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Category getCategoryById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Iterable<Category> getListCategory() {
        List<Category> allCat = categoryRepository.findAll();

        // get most Recent Article
        for(var cat : allCat) {
            cat.setMostRecentArticle(articleRepository.findLatestArticle(cat.getId()));
            cat.setNumArticles(articleRepository.countArticleByCategory(cat.getId()));
        }
        return allCat;
    }

}
