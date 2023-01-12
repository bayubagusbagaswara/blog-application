package com.bayu.blog.service;

import com.bayu.blog.payload.CommentDTO;

public interface CommentService {

    CommentDTO createComment(long postId, CommentDTO commentDTO);

}
