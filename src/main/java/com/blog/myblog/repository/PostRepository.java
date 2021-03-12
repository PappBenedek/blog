package com.blog.myblog.repository;

import com.blog.myblog.domain.Post;
import com.blog.myblog.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {

    @Query(value = "select * from posts order by date desc ;", nativeQuery = true)
    List<Post> findAll();

    @Query(value = "select * from posts where user_id = ?1", nativeQuery = true)
    List<Post> findAllByUser(long id);

    List<Post> findByTitleContains(String title);
}
