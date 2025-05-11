package com.rudy.blog.post.response;

import com.rudy.blog.post.domain.Post;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
public class PostResponse {
    private final Long id;
    private final String title;
    private final String content;
    private final String author;
    private final List<MultipartFile> images = new ArrayList<>();
    private final List<MultipartFile> files = new ArrayList<>();
    private final Instant createDateTime;
    private final Instant updateDateTime;

    public PostResponse(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.author = post.getAuthor();
        this.createDateTime = Instant.from(post.getCreateDateTime());
        this.updateDateTime = Instant.from(post.getUpdateDateTime());
    }

    public void addImage(MultipartFile image) {
        this.images.add(image);
    }

    public void addFile(MultipartFile file) {
        this.files.add(file);
    }
}
