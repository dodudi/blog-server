package com.rudy.blog.post.response;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UploadResponse {
    private final Long id;
    private final String fileName;
    private final LocalDateTime createDateTime;
    private final LocalDateTime updateDateTime;

    public UploadResponse(Long id, String fileName, LocalDateTime createDateTime, LocalDateTime updateDateTime) {
        this.id = id;
        this.fileName = fileName;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
    }
}