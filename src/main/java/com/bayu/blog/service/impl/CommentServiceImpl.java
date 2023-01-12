package com.bayu.blog.service.impl;

import com.bayu.blog.payload.CommentDTO;
import com.bayu.blog.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Override
    public CommentDTO createComment(long postId, CommentDTO commentDTO) {
        return null;
    }
}
