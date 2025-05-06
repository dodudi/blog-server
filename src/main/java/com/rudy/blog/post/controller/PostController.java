package com.rudy.blog.post.controller;

import com.rudy.blog.post.request.PostRequest;
import com.rudy.blog.post.response.PostResponse;
import com.rudy.blog.post.service.PostService;
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
    public ResponseEntity<Page<PostResponse>> getPosts(Pageable pageable) {
        Page<PostResponse> posts = postService.getPosts(pageable);
        return ResponseEntity.ok(posts);
    }

    @PostMapping
    public ResponseEntity<PostResponse> savePost(@RequestBody PostRequest postRequest) {
        PostResponse post = postService.savePost(postRequest);
        return ResponseEntity.ok(post);
    }
}
