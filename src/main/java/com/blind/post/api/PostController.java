package com.blind.post.api;

import com.blind.post.api.dto.response.*;
import com.blind.post.api.service.*;
import com.blind.post.domain.*;
import com.blind.post.persistence.repository.*;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.util.*;

@RestController("/api/v1/posts")
public class PostController {
    private final PostRepository postRepository;

    @Autowired
    private PostService postService;

    @Autowired
    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "NOT_FOUND"),
            @ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR"),
    })
    @GetMapping()
    ResponseEntity<?> listAll(Pageable pageable) {
        Page<PostResponse> postList = postService.getPostList(pageable);
        if (!postList.isEmpty()) return ResponseEntity.status(HttpStatus.OK).body(postList);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Couldn't find any posts");
    }

    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "NOT_FOUND"),
            @ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR"),
    })
    @GetMapping("/{id}")
    ResponseEntity<?> findPost(@PathVariable UUID id) {
        PostResponse postResponse = postService.getPost(id);
        if (postResponse != null) return ResponseEntity.status(HttpStatus.OK).body(postResponse);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Couldn't find any posts with the id " + id);
    }

    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "BAD_REQUEST"),
            @ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR"),
    })
    @PostMapping()
    Post createPost(@Valid @RequestBody Post post) {
        postRepository.save(post);
        return post;
    }

    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "NOT_FOUND"),
            @ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR"),
    })
    public ResponseEntity<Post> updatePost(@PathVariable("id") UUID id, @RequestBody Post post) {
        Optional<Post> postData = postRepository.findById(id);
        if (postData.isPresent()) {
            Post updatedPost = postData.get();
            updatedPost.setTitle(post.getTitle());
            updatedPost.setContent(post.getContent());
            return new ResponseEntity<>(postRepository.save(updatedPost), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "BAD_REQUEST"),
            @ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR"),
    })
    @GetMapping("/{id}")
    ResponseEntity<String> deletePost (@PathVariable UUID id) {
        try {
            postRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
