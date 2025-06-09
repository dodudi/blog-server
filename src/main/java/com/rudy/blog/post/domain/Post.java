package com.rudy.blog.post.domain;

import com.rudy.blog.global.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;
    private String author;
    private String format;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<PostTag> postTags = new ArrayList<>();

    public Post(String title, String content, String author, String format) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.format = format;
    }

    public void addTag(Tag tag) {
        PostTag postTag = new PostTag(this, tag);
        this.postTags.add(postTag);
    }
}
