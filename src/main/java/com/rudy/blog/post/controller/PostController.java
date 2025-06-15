package com.rudy.blog.post.controller;

import com.rudy.blog.global.response.ApiResponse;
import com.rudy.blog.post.request.PostRequest;
import com.rudy.blog.post.request.PostUpdateRequest;
import com.rudy.blog.post.response.PostResponse;
import com.rudy.blog.post.service.PostService;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity<ApiResponse> getPosts(Pageable pageable) {
        Page<PostResponse> posts = postService.getPosts(pageable);
        return ResponseEntity.ok(ApiResponse.ok(posts));
    }

    @GetMapping("/{post_id}")
    public ResponseEntity<ApiResponse> getPost(@PathVariable(value = "post_id") Long postId) {
        PostResponse post = postService.getPost(postId);
        return ResponseEntity.ok(ApiResponse.ok(post));
    }

    @PostMapping
    public ResponseEntity<ApiResponse> savePost(
            @Valid @Parameter @RequestBody PostRequest postRequest
    ) {
        PostResponse post = postService.savePost(postRequest);
        return ResponseEntity.ok(ApiResponse.ok(post));
    }

    @PutMapping("/{post_id}")
    public ResponseEntity<ApiResponse> updatePost(
            @PathVariable(value = "post_id") Long postId,
            @Valid @Parameter @RequestBody PostUpdateRequest postUpdateRequest
    ) {
        PostResponse post = postService.updatePost(postId, postUpdateRequest);
        return ResponseEntity.ok(ApiResponse.ok(post));
    }
}
