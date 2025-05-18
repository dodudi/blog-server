package com.rudy.blog.post.service;

import com.rudy.blog.post.domain.Post;
import com.rudy.blog.post.repository.PostRepository;
import com.rudy.blog.post.request.PostRequest;
import com.rudy.blog.post.response.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    /**
     * 게시물을 페이징 조회하는 메서드
     *
     * @return 조회한 페이징 게시물을 응답합니다.
     */
    public Page<PostResponse> getPosts(Pageable pageable) {
        Page<Post> posts = postRepository.findAll(pageable);
        return posts.map(PostResponse::new);
    }

    /**
     * 게시물 아이디로 조회하는 메서드
     */
    public PostResponse getPost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("post not found"));

        return new PostResponse(post);
    }


    /**
     * 게시물을 저장하는 메서드
     *
     * @return 저장한 게시물의 정보를 응답합니다.
     */
    @Transactional
    public PostResponse savePost(PostRequest postRequest) {
        Post post = new Post(postRequest.getTitle(), postRequest.getContent(), "", postRequest.getFormat());
        post = postRepository.save(post);

        return new PostResponse(post);
    }
}
