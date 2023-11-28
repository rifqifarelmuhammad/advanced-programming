package id.ac.ui.cs.advprog.commentservice.service;

import id.ac.ui.cs.advprog.commentservice.model.Comment;
import id.ac.ui.cs.advprog.commentservice.repository.CommentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentServiceImplTest {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentServiceImpl commentService;

    @Test
    void deleteCommentTest() {
        Comment comment = new Comment();
        comment.setPostId(1);
        comment.setAuthor("Indra Mahaarta");
        comment.setContent("Content 2");
        comment.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
        comment = commentRepository.save(comment);

        commentService.delete(comment.getId());

        assertFalse(commentRepository.findById(comment.getId()).isPresent());
    }
}