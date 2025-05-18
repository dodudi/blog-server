package com.rudy.blog.post.request;

import lombok.Getter;

@Getter
public class PostRequest {
    private final String title;
    private final String content;
    private final String format;

    public PostRequest(String title, String content, String format) {
        this.title = title;
        this.content = content;
        this.format = format;
    }
}
