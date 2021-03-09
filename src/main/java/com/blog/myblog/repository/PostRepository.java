package com.blog.myblog.repository;

import com.blog.myblog.domain.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {

    @Query(value = "select * from posts;", nativeQuery = true)
    List<Post> findAll();
}
