package com.blind.post.api.service;


import com.blind.post.api.dto.response.PostResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface PostService {
    PostResponse getPost(UUID id);
    Page<PostResponse> getPostList(Pageable pageable);
}
