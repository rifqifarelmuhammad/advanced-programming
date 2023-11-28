package id.ac.ui.cs.advprog.commentservice.service;

import id.ac.ui.cs.advprog.commentservice.dto.CommentRequest;
import id.ac.ui.cs.advprog.commentservice.model.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

    Comment create(CommentRequest commentRequest, Integer postId);
    List<Comment> findAllByPostId(Integer postId);
    void delete(Integer id);
    void deleteAllByPostId(Integer postId);
}
