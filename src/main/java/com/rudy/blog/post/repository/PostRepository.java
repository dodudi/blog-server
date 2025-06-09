package com.rudy.blog.post.repository;

import com.rudy.blog.post.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("SELECT DISTINCT p FROM Post p " +
            "LEFT JOIN FETCH p.postTags pt " +
            "LEFT JOIN FETCH pt.tag")
    Page<Post> findAllWithTags(Pageable pageable);
}
