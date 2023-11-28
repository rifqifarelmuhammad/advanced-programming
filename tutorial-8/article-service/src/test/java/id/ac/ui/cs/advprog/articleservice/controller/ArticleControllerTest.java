package id.ac.ui.cs.advprog.articleservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import id.ac.ui.cs.advprog.articleservice.model.Article;
import id.ac.ui.cs.advprog.articleservice.model.dto.CreateArticleDTO;
import id.ac.ui.cs.advprog.articleservice.service.ArticleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@WebMvcTest(controllers = ArticleController.class)
class ArticleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ArticleService articleService;

    private Article article1;

    private Article article2;

    private List<Article> listArticle;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        var timestamp = Timestamp.valueOf(LocalDateTime.of(2023, 4,30,12, 12, 12));
        article1 = new Article(1, "Title 1", "Content 1", "Author 1",timestamp);
        article2 = new Article(2, "Title 2", "Content 2", "Author 2", timestamp);
        listArticle = new ArrayList<>();
        listArticle.add(article1);
        listArticle.add(article2);

        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        lenient().when(articleService.findArticleById(1)).thenReturn(article1);
        lenient().when(articleService.getAllArticles()).thenReturn(listArticle);

    }

    @Test
    void testGetAllArticles() throws Exception {
        var expectedResponseContent = "[{\"id\":1,\"author\":\"Title 1\",\"title\":\"Content 1\",\"content\":\"Author 1\",\"timestamp\":\"2023-04-30T05:12:12.000+00:00\"},{\"id\":2,\"author\":\"Title 2\",\"title\":\"Content 2\",\"content\":\"Author 2\",\"timestamp\":\"2023-04-30T05:12:12.000+00:00\"}]";

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/article/get-all-posts"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedResponseContent));
    }

    @Test
    void testGetArticleById() throws Exception {
        var expectedResponseContent = "{\"id\":1,\"author\":\"Title 1\",\"title\":\"Content 1\",\"content\":\"Author 1\",\"timestamp\":\"2023-04-30T05:12:12.000+00:00\"}";
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/article/get-post/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedResponseContent));
    }

    @Test
    void testCreateArticle() throws Exception {
        CreateArticleDTO createArticleDTO = new CreateArticleDTO();
        createArticleDTO.setTitle("Title 1");
        createArticleDTO.setContent("Content 1");
        createArticleDTO.setAuthor("Author 1");

        var expectedResponseContent = "{\"id\":1,\"author\":\"Title 1\",\"title\":\"Content 1\",\"content\":\"Author 1\",\"timestamp\":\"2023-04-30T05:12:12.000+00:00\"}";

        when(articleService.createArticle(any(CreateArticleDTO.class))).thenReturn(article1);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/article/create-post")
                        .content(objectMapper.writeValueAsString(createArticleDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedResponseContent));
    }

    @Test
    void testDeleteArticle() throws Exception {
        Integer id = 1;

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/article/delete-post/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(String.format("Deleted Article with id %d", id)));
    }
}
