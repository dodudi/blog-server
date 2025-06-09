package com.rudy.blog.post.repository;

import com.rudy.blog.post.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
