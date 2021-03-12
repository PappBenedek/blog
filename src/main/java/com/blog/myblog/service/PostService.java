package com.blog.myblog.service;

import com.blog.myblog.domain.Post;
import com.blog.myblog.domain.User;
import com.blog.myblog.repository.PostRepository;
import com.blog.myblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    private PostRepository postRepository;
    private UserRepository userRepository;
    @Autowired
    public void setUserRepository(UserRepository userRepository) { this.userRepository = userRepository; }
    @Autowired
    public void setPostRepository(PostRepository postRepository) { this.postRepository = postRepository; }



    public List<Post> getAllPost(){
        return postRepository.findAll();
    }

    public List<Post> getPostsByTitle(String title){
        return postRepository.findByTitleContains(title);
    }

    public List<Post> getPostsByAuthot(String authot){
        User user = userRepository.findByEmail(authot);
        List<Post> posts = postRepository.findAllByUser(user.getId());
        return posts;
    }

    public void savePost(Post post, String email){
        User user = userRepository.findByEmail(email);
        post.setUser(user);
        post.setDate(new Date());
        postRepository.save(post);
    }
}
