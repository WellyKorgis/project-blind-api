package com.blind.api.controller;

import com.blind.api.post.domain.Post;
import com.blind.api.post.repository.PostRepository;
import com.blind.api.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostController {
    @Autowired
    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    String list() {
        return "hi";
    }

    @GetMapping("/posts")
    ResponseEntity<List<Post>> listAll() {
        List<Post> posts = postService.listAllPosts();
        return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
    }
}
