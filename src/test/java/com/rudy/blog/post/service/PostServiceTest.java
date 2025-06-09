package com.rudy.blog.post.service;

import com.rudy.blog.post.request.PostRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Set;


@ActiveProfiles("test")
@SpringBootTest
class PostServiceTest {

    @Autowired
    private PostService postService;

    @Test
    void savePost() {
        PostRequest postRequest = new PostRequest("test title", "test content", "MARKDOWN", Set.of("test", "test2", "test3"));
        PostRequest postRequest2 = new PostRequest("test title2", "test content2", "MARKDOWN", Set.of("test3", "test4", "test5"));
        PostRequest postRequest3 = new PostRequest("test title3", "test content3", "MARKDOWN", Set.of("test6", "test7", "test8"));
        postService.savePost(postRequest);
        postService.savePost(postRequest2);
        postService.savePost(postRequest3);


    }
}