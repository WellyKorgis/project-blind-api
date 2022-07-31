package com.blind.post.api.service;

import com.blind.post.api.dto.response.PostResponse;
import com.blind.post.api.mapper.PostMapper;
import com.blind.post.domain.Post;
import com.blind.post.persistence.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;
    private PostMapper postMapper;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, PostMapper postMapper)
    {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    @Override
    public PostResponse getPost(UUID id) {
        Post post = postRepository.findById(id).orElse(null);;

        if (post == null) return null;
        else return postMapper.postToDto(post);
    }

    @Override
    public Page<PostResponse> getPostList(Pageable pageable) {
        return postRepository.findAll(pageable).map(postMapper::postToDto);
    }
}
