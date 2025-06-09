package com.rudy.blog.post.response;

import com.rudy.blog.post.domain.Post;
import lombok.Getter;

import java.time.Instant;
import java.util.List;

@Getter
public class PostResponse {
    private final Long id;
    private final String title;
    private final String content;
    private final String author;
    private final List<String> tags;
    private final Instant createDateTime;
    private final Instant updateDateTime;

    public PostResponse(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.author = post.getAuthor();
        this.tags = post.getPostTags().stream()
                .map(postTags -> postTags.getTag().getTagName())
                .toList();
        this.createDateTime = post.getCreateDateTime();
        this.updateDateTime = post.getUpdateDateTime();
    }
}
