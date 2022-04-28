package com.blind.api.controller;

import com.blind.api.job.domain.JobCategory;
import com.blind.api.job.domain.JobPosition;
import com.blind.api.post.domain.Post;
import com.blind.api.post.repository.PostRepository;
import com.blind.api.post.service.PostService;
import com.blind.api.user.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@ExtendWith(SpringExtension.class)
@WebMvcTest(PostController.class)
public class PostControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    private PostService postService;

    @Test
    public void getAllPosts() throws Exception {
        Post post1 = new Post("title", "content", new User("user", "email@email.com", new JobPosition("worker", new JobCategory("retail")), true));

        given(postService.save(post1)).willReturn(post1);

        final ResultActions actions = mockMvc.perform(get("/posts")
                .contentType(MediaType.APPLICATION_JSON)).andDo(print());

        actions.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
    }
}