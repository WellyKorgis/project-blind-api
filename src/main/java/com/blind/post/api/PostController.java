package com.blind.post.api;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
    private final PostRepository postRepository;

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
