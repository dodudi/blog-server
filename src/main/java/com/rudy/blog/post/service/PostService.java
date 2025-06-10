package com.rudy.blog.post.service;

import com.rudy.blog.post.domain.Post;
import com.rudy.blog.post.domain.Tag;
import com.rudy.blog.post.repository.PostRepository;
import com.rudy.blog.post.repository.TagRepository;
import com.rudy.blog.post.request.PostRequest;
import com.rudy.blog.post.request.PostUpdateRequest;
import com.rudy.blog.post.response.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final TagRepository tagRepository;

    /**
     * 게시물을 페이징 조회하는 메서드
     *
     * @return 조회한 페이징 게시물을 응답합니다.
     */
    public Page<PostResponse> getPosts(Pageable pageable) {
        Page<Post> posts = postRepository.findAllWithTags(pageable);
        return posts.map(PostResponse::new);
    }

    /**
     * 게시물 아이디로 조회하는 메서드
     */
    public PostResponse getPost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("post not found"));
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
        for (String tagName : postRequest.getTags()) {
            Tag tag = tagRepository.findByTagName(tagName).orElseGet(() -> new Tag(tagName));
            post.addPostTag(tagRepository.save(tag));
        }

        post = postRepository.save(post);
        return new PostResponse(post);
    }


    /**
     * 게시물을 수정하는 메서드
     *
     * @return 수정된 게시물의 정보를 응답합니다.
     */
    @Transactional
    public PostResponse updatePost(Long postId, PostUpdateRequest postUpdateRequest) {
        Assert.notNull(postId, "postId must not be null");

        Post post = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("post not found"));

        // Post 기본 정보 업데이트
        post.updatePost(postUpdateRequest.getTitle(), postUpdateRequest.getContent());

        // Post 태그 정보 업데이트
        Set<String> updateTags = postUpdateRequest.getTags();
        Set<Tag> addTags = updateTags.stream().map(tagName -> {
            Tag tag = tagRepository.findByTagName(tagName).orElseGet(() -> new Tag(tagName));
            post.addPostTag(tagRepository.save(tag));
            return tag;
        }).collect(Collectors.toSet());

        post.removePostTags(addTags);

        return new PostResponse(postRepository.save(post));
    }
}
