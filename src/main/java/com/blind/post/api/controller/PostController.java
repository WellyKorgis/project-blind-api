package com.blind.post.api;

import com.blind.post.domain.Post;
import com.blind.post.persistence.repository.PostRepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


@RestController("/api/v1")
public class PostController {
    private final PostRepository postRepository;

    @Autowired
    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "NOT_FOUND"),
            @ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR"),
    })
    @GetMapping("/posts")
    List<Post> listAll() {
        return postRepository.findAll();
    }

    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "NOT_FOUND"),
            @ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR"),
    })
    @GetMapping("/posts/{id}")
    Optional<Post> findPost(Integer id) {
        return postRepository.findById(id);
    }

    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "BAD_REQUEST"),
            @ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR"),
    })
    @PostMapping("/post")
    Post createPost(@RequestBody Post post) {
        postRepository.save(post);
        return post;
    }
}
