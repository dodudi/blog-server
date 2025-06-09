package com.rudy.blog.post.request;

import lombok.Getter;

import java.util.Set;

@Getter
public class PostRequest {
    private final String title;
    private final String content;
    private final String format;
    private final Set<String> tags;

    public PostRequest(String title, String content, String format, Set<String> tags) {
        this.title = title;
        this.content = content;
        this.format = format;
        this.tags = tags;
    }
}
