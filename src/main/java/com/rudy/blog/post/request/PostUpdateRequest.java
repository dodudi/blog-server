package com.rudy.blog.post.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.Set;

@Getter
public class PostUpdateRequest {

    @NotNull(message = "title must not be null")
    private final String title;

    @NotNull(message = "content must not be null")
    private final String content;
    
    private final Set<String> tags;

    public PostUpdateRequest(String title, String content, Set<String> tags) {
        this.title = title;
        this.content = content;
        this.tags = tags == null ? Set.of() : tags;
    }
}
