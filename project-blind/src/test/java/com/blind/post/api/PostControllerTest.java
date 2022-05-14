package com.blind.post.api;

import com.blind.account.domain.Account;
import com.blind.post.api.PostController;
import com.blind.post.domain.Post;
import com.blind.post.persistence.repository.PostRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostControllerTest {
    @InjectMocks
    PostController postController;

    @Mock
    PostRepository postRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listAll() {
        //given
        Post post1 = new Post(
                "title",
                "content",
                new Account(
                        "user",
                        "email@email.com")

        );
        List<Post> postList = new ArrayList<>();
        postList.add(post1);
        when(postRepository.findAll()).thenReturn(postList);

        //when
        List<Post> actual = postRepository.findAll();
        //then
        Assertions.assertEquals("title",actual.get(0).getTitle());
    }

    @Test
    void creatPost() {
        //given
        Post post1 = new Post(
                "title",
                "content",
                new Account(
                        "user",
                        "email@email.com")

        );
        //when
        when(postRepository.save(any())).thenReturn(post1);
        Post actual = postRepository.save(post1);
        //then
        Assertions.assertEquals("title", actual.getTitle());
    }
}