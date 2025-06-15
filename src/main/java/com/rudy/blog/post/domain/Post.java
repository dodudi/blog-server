package com.rudy.blog.post.domain;

import com.rudy.blog.global.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    public void addPostTag(Tag tag) {
        if (this.postTags.stream().noneMatch(postTag -> postTag.getTag().equals(tag))) {
            PostTag postTag = new PostTag(this, tag);
            this.postTags.add(postTag);
        }
    }

    public void updatePost(String title, String content) {
        this.title = StringUtils.hasText(title) ? title : this.title;
        this.content = StringUtils.hasText(content) ? content : this.content;
    }

    /**
     * @param tags 삭제하고 싶지 않은 Tag 리스트, 입력 받은 {@code tags} 를 제외한 모든 연결된 post_tag 삭제
     */
    public void removePostTags(Set<Tag> tags) {
        this.postTags.removeIf(postTag -> !tags.contains(postTag.getTag()));
    }
}
