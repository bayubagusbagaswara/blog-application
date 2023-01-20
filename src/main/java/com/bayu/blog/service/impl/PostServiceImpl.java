package com.bayu.blog.service.impl;

import com.bayu.blog.entity.Category;
import com.bayu.blog.entity.Comment;
import com.bayu.blog.entity.Post;
import com.bayu.blog.exception.ResourceNotFoundException;
import com.bayu.blog.payload.CommentDTO;
import com.bayu.blog.payload.PostDTO;
import com.bayu.blog.payload.PostResponse;
import com.bayu.blog.repository.CategoryRepository;
import com.bayu.blog.repository.PostRepository;
import com.bayu.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, CategoryRepository categoryRepository) {
        this.postRepository = postRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public PostDTO createPost(PostDTO postDTO) {

        Category category = categoryRepository.findById(postDTO.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", postDTO.getCategoryId()));

        // convert DTO to entity
        Post post = mapToEntity(postDTO);
        post.setCategory(category);

        Post newPost = postRepository.save(post);

        // convert entity to DTO
        return mapToDTO(newPost);
    }

    @Override
    public PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        // create Pageable instance
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());

        Page<Post> posts = postRepository.findAll(pageable);

        // get content for page object
        List<Post> listOfPosts = posts.getContent();

        List<PostDTO> content = listOfPosts.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(content);
        postResponse.setPageNo(posts.getNumber());
        postResponse.setPageSize(posts.getSize());
        postResponse.setTotalElements(posts.getTotalElements());
        postResponse.setTotalPages(posts.getTotalPages());
        postResponse.setLast(posts.isLast());

        return postResponse;
    }

    @Override
    public PostDTO getPostById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        return mapToDTO(post);
    }

    @Override
    public void deletePostById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        postRepository.delete(post);
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO, Long id) {
        // get post by id from the database
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        Category category = categoryRepository.findById(postDTO.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", postDTO.getCategoryId()));


        post.setTitle(postDTO.getTitle());
        post.setDescription(postDTO.getDescription());
        post.setContent(postDTO.getContent());
        post.setCategory(category);

        Post save = postRepository.save(post);

        return mapToDTO(save);
    }

    private PostDTO mapToDTO(Post post) {
        PostDTO postDTO = new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setTitle(post.getTitle());
        postDTO.setDescription(post.getDescription());
        postDTO.setContent(post.getContent());
        postDTO.setComments(post.getComments().stream().map(comment -> {
            CommentDTO commentDTO = new CommentDTO();
            commentDTO.setId(comment.getId());
            commentDTO.setName(comment.getName());
            commentDTO.setEmail(comment.getEmail());
            commentDTO.setBody(comment.getBody());
            return commentDTO;
        }).collect(Collectors.toSet()));

        return postDTO;
    }

    private Post mapToEntity(PostDTO postDTO) {
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setDescription(postDTO.getDescription());
        post.setContent(postDTO.getContent());
        post.setComments(postDTO.getComments().stream().map(commentDTO -> {
            Comment comment = new Comment();
            comment.setId(commentDTO.getId());
            comment.setName(commentDTO.getName());
            comment.setEmail(commentDTO.getEmail());
            comment.setBody(commentDTO.getBody());
            return comment;
        }).collect(Collectors.toSet()));

        return post;
    }

}
