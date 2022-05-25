package com.blind.post.api;

import com.blind.post.domain.*;
import com.blind.post.persistence.repository.PostRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class PostController {
    private final PostRepository postRepository;

    @Autowired
    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/posts")
    List<Post> listAll() {
        return postRepository.findAll();
    }

    @PostMapping("/post")
    Post createPost(@RequestBody Post post) {
        postRepository.save(post);
        return post;
    }
}
