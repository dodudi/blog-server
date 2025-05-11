package com.rudy.blog.post.service;

import com.rudy.blog.post.domain.Post;
import com.rudy.blog.post.repository.PostRepository;
import com.rudy.blog.post.request.PostRequest;
import com.rudy.blog.post.response.PostResponse;
import com.rudy.blog.post.response.UploadResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final RestClient restClient;

    @Value("${url.file-server}")
    private String fileServerUrl;

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
     * 게시물을 저장하는 메서드
     *
     * @return 저장한 게시물의 정보를 응답합니다.
     */
    public PostResponse savePost(PostRequest postRequest) {
        List<MultipartFile> images = postRequest.getImages();
        List<MultipartFile> files = postRequest.getFiles();
        ResponseEntity<List<UploadResponse>> uploadEntity = restClient.post()
                .uri(fileServerUrl + "/upload")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(images)
                .retrieve()
                .toEntity(new ParameterizedTypeReference<>() {
                });

        List<UploadResponse> uploads = uploadEntity.getBody();


        Post post = new Post(postRequest.getTitle(), postRequest.getContent(), "", postRequest.getFormat());
        return new PostResponse(post);
    }
}
