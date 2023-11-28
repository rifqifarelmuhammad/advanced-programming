package id.ac.ui.cs.advprog.commentservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.ac.ui.cs.advprog.commentservice.dto.CommentRequest;
import id.ac.ui.cs.advprog.commentservice.model.Comment;
import id.ac.ui.cs.advprog.commentservice.service.CommentService;
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
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@WebMvcTest(controllers = CommentController.class)
class CommentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CommentService commentService;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void testCreateComment() throws Exception {
        CommentRequest commentRequest = new CommentRequest("Author", "Content");
        Comment comment = new Comment(1, 1, "Author", "Content", Timestamp.valueOf(LocalDateTime.of(2023, 4,30,12, 12, 12)));

        when(commentService.create(any(CommentRequest.class), any(Integer.class))).thenReturn(comment);

        String expectedResponseContent = "{\"id\":1,\"postId\":1,\"author\":\"Author\",\"content\":\"Content\",\"timestamp\":\"2023-04-30T05:12:12.000+00:00\"}";

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/comment/create-comment/{postId}", 1)
                        .content(objectMapper.writeValueAsString(commentRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedResponseContent));

        verify(commentService, times(1)).create(any(CommentRequest.class), any(Integer.class));
    }

    @Test
    void testFindAllByPostId() throws Exception {
        Comment comment1 = new Comment(1, 1, "Indra", "Content 1",
                Timestamp.valueOf(LocalDateTime.of(2023, 4,30,12, 12, 12)));
        Comment comment2 = new Comment(2, 1, "Mahaarta", "Content 2", Timestamp.valueOf(LocalDateTime.of(2023, 4,30,12, 12, 12)));
        List<Comment> comments = Arrays.asList(comment1, comment2);

        String expectedResponseContent = "[{\"id\":1,\"postId\":1,\"author\":\"Indra\",\"content\":\"Content 1\",\"timestamp\":\"2023-04-30T05:12:12.000+00:00\"},{\"id\":2,\"postId\":1,\"author\":\"Mahaarta\",\"content\":\"Content 2\",\"timestamp\":\"2023-04-30T05:12:12.000+00:00\"}]";


        when(commentService.findAllByPostId(any(Integer.class))).thenReturn(comments);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/comment/get-all-comments/{postId}", 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedResponseContent));

        verify(commentService, times(1)).findAllByPostId(any(Integer.class));
    }

    @Test
    void testDeleteComment() throws Exception {
        Integer id = 1;

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/comment/delete-comment/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(String.format("Deleted Comment with id %d", id)));

        verify(commentService, times(1)).delete(any(Integer.class));
    }
}