package com.blind.api.controller;

import com.blind.account.domain.Account;
import com.blind.company.api.controller.CompanyController;
import com.blind.company.api.mapper.CompanyMapper;
import com.blind.company.api.service.CompanyService;
import com.blind.post.api.PostController;
import com.blind.post.api.dto.response.PostResponse;
import com.blind.post.api.mapper.PostMapper;
import com.blind.post.api.service.PostService;
import com.blind.post.domain.Post;
import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Log4j
@WebMvcTest(controllers = PostController.class)
@ExtendWith(MockitoExtension.class)
public class PostControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private PostService postService;

    @Mock
    private PostMapper postMapper;

    @Test
    public void getPostList() throws Exception {

        final Account account = new Account("username", "email@mail.com");
        Post post1 = new Post("title1", "content", account);
        Post post2 = new Post("title2", "content", account);
        Post post3 = new Post("title3", "content", account);

        final List<Post> postList = new ArrayList<>();

        postList.add(post1);
        postList.add(post2);
        postList.add(post3);

        final List<PostResponse> postResponse = postMapper.postListToDto(postList);

        Pageable pageable = PageRequest.of(0, 20);
        Page<PostResponse> pagedResponses = new PageImpl<>(postResponse);

        when(postService.getPostList(pageable)).thenReturn(pagedResponses);

        this.mockMvc.perform(get("/api/v1/posts"))
                .andExpect(status().isOk())
        ;

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/posts")
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        String content = mvcResult.getResponse().getContentAsString();

        verify(postService).getPostList(pageable);
    }
}
