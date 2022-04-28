package com.blind.api.post.service;

import com.blind.api.post.domain.Post;
import com.blind.api.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;
    public List<Post> listAllPosts() {
        List<Post> posts = new ArrayList<>();
        postRepository.findAll().forEach(e -> posts.add(e));
        return posts;
    }

    public Post save(Post newPost) {
        return postRepository.save(newPost);
    }
}
