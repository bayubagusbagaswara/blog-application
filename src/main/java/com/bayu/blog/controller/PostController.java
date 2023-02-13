package com.bayu.blog.controller;

import com.bayu.blog.payload.PostDTO;
import com.bayu.blog.payload.PostDTOV2;
import com.bayu.blog.payload.PostResponse;
import com.bayu.blog.service.PostService;
import com.bayu.blog.utils.AppConstants;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // create blog post rest api
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/api/v1/posts")
    public ResponseEntity<PostDTO> createPost(@Valid @RequestBody PostDTO postDTO) {
        return new ResponseEntity<>(postService.createPost(postDTO), HttpStatus.CREATED);
    }

    // get all posts rest api
    @GetMapping("/api/v1/posts")
    public PostResponse getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir) {

        return postService.getAllPosts(pageNo, pageSize, sortBy, sortDir);
    }

    // get post by id
    @GetMapping("/api/v1/posts/{id}")
    public ResponseEntity<PostDTO> getPostByIdV1(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @GetMapping("/api/v2/posts/{id}")
    public ResponseEntity<PostDTOV2> getPostByIdV2(@PathVariable(name = "id") Long id) {
        PostDTO postDTO = postService.getPostById(id);
        PostDTOV2 postDTOV2 = new PostDTOV2();
        postDTOV2.setId(postDTO.getId());
        postDTOV2.setTitle(postDTO.getTitle());
        postDTOV2.setDescription(postDTO.getDescription());
        postDTOV2.setContent(postDTO.getContent());
        List<String> tags = new ArrayList<>();
        tags.add("Java");
        tags.add("Spring Boot");
        tags.add("AWS");
        postDTOV2.setTags(tags);
        return ResponseEntity.ok(postDTOV2);
    }

    // update post by id
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/api/v1/posts/{id}")
    public ResponseEntity<PostDTO> updatePost(@Valid @RequestBody PostDTO postDTO, @PathVariable(name = "id") Long id) {
        PostDTO postResponse = postService.updatePost(postDTO, id);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    // delete post
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/api/v1/posts/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id") Long id) {
        postService.deletePostById(id);
        return new ResponseEntity<>("Post entity deleted successfully", HttpStatus.OK);
    }

    // Build Get Posts by Category REST API
    // http://localhost:8080/api/posts/category/3
    @GetMapping("/api/v1/posts/category/{id}")
    public ResponseEntity<List<PostDTO>> getPostsByCategory(@PathVariable(value = "id") Long categoryId) {
        List<PostDTO> postDTOList = postService.getPostsByCategory(categoryId);
        return ResponseEntity.ok(postDTOList);
    }
}
