package com.rudy.blog.post.domain;

import com.rudy.blog.global.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostFile extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileOriginalName;
    private String fileHashName;
    private String fileFullPath;
    private Long fileSize;
    private String fileType;

    public PostFile(String fileOriginalName, String fileHashName, String fileType, String fileFullPath, Long fileSize) {
        this.fileOriginalName = fileOriginalName;
        this.fileHashName = fileHashName;
        this.fileType = fileType;
        this.fileFullPath = fileFullPath;
        this.fileSize = fileSize;
    }
}
