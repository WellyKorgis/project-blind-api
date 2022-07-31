package com.blind.post.api;

import com.blind.post.domain.*;
import com.blind.post.persistence.repository.*;
import io.swagger.annotations.*;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.util.*;

@RestController("/api/v1/posts")
public class PostController {
    private final PostRepository postRepository;

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
    List<Post> listAll() {
        return postRepository.findAll();
    }

    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "NOT_FOUND"),
            @ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR"),
    })
    @GetMapping("{id}")
    Optional<Post> findPost(UUID id) {
        return postRepository.findById(id);
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
