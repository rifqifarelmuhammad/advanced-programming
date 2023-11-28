package id.ac.ui.cs.advprog.commentservice.service;

import id.ac.ui.cs.advprog.commentservice.dto.ArticleResponse;
import id.ac.ui.cs.advprog.commentservice.dto.CommentRequest;
import id.ac.ui.cs.advprog.commentservice.model.Comment;
import id.ac.ui.cs.advprog.commentservice.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final RestTemplate restTemplate;
    private final String otherInstanceURL = "http://localhost:8080/api/v1/article/";

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, RestTemplate restTemplate) {
        this.commentRepository = commentRepository;
        this.restTemplate = restTemplate;
    }

    public boolean getPostViaId(Integer postId) {
        ArticleResponse article = restTemplate.getForObject(otherInstanceURL + "get-post/" + postId, ArticleResponse.class);
        return article != null;
    }

    @Override
    public Comment create(CommentRequest commentRequest, Integer postId) {
        if(getPostViaId(postId)) {
            Comment comment = Comment.builder()
                            .postId(postId)
                            .author(commentRequest.getAuthor())
                            .content(commentRequest.getContent())
                            .timestamp(new Timestamp(System.currentTimeMillis()))
                            .build();
            return this.commentRepository.save(comment);
        } return null;
    }

    @Override
    public List<Comment> findAllByPostId(Integer postId) {
        return commentRepository.findAllByPostId(postId);
    }

    @Override
    public void delete(Integer id) {
        commentRepository.deleteById(id);
    }

    @Override
    public void deleteAllByPostId(Integer postId){
        commentRepository.deleteAllByPostId(postId);
    }
}
