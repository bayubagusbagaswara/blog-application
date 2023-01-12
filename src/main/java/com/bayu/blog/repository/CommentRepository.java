package com.bayu.blog.repository;

import com.bayu.blog.entity.Comment;
import com.bayu.blog.payload.CommentDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByPostId(long postId);

    List<CommentDTO> getCommentsByPostId(long postId);
}
