package com.blind.post.api;

import com.blind.post.domain.Post;
import com.blind.post.persistence.repository.PostRepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController("/v1/post")
public class PostController {
    private final PostRepository postRepository;

    @Autowired
    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/")
    List<Post> listAll() {
        return postRepository.findAll();
    }

    @PostMapping("/")
    Post createPost(@RequestBody Post post) {
        postRepository.save(post);
        return post;
    }
}
