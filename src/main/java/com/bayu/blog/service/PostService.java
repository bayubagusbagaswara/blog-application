package com.bayu.blog.service;

import com.bayu.blog.payload.PostDTO;

import java.util.List;

public interface PostService {

    PostDTO createPost(PostDTO postDTO);

    List<PostDTO> getAllPosts();

    PostDTO getPostById(Long id);

    PostDTO updatePost(PostDTO postDTO, long id);
}
