package com.blind.api.controller;

import com.blind.api.post.domain.Post;
import com.blind.api.post.repository.PostRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {
    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/")
    String list() {
        return "hi";
    }

    @GetMapping("/posts")
    List<Post> listAll() {
        return postRepository.findAll();
    }
}
