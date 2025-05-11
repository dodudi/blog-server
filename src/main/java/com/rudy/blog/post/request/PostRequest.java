package com.rudy.blog.post.request;

import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
public class PostRequest {
    private final String title;
    private final String content;
    private final String format;
    private final List<MultipartFile> images;
    private final List<MultipartFile> files;

    public PostRequest(String title, String content, String format, List<MultipartFile> images, List<MultipartFile> files) {
        this.title = title;
        this.content = content;
        this.format = format;
        this.images = images;
        this.files = files;
    }
}
