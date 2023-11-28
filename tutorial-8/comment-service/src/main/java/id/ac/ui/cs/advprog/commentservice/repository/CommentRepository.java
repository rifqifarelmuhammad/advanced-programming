package id.ac.ui.cs.advprog.commentservice.repository;

import id.ac.ui.cs.advprog.commentservice.model.Comment;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @NonNull
    List<Comment> findAllByPostId(@NonNull Integer postId);

    void deleteById(@NonNull Integer id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM comment WHERE post_id = ?1", nativeQuery = true)
    void deleteAllByPostId(@NonNull Integer postId);
}
