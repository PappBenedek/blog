package com.blog.myblog.controller;

import com.blog.myblog.domain.Post;
import com.blog.myblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PostController {
    private PostService postService;
    @Autowired
    public void setPostService(PostService postService) { this.postService = postService; }

    @GetMapping("/posts")
    public String getAllPost(Model model){
        model.addAttribute("posts",postService.getAllPost());
        return "posts";
    }

    @GetMapping("/createpost")
    public String getCreatePost(Model model){
        model.addAttribute("post",new Post());
        return "createpost";
    }

    @PostMapping("/createpost/{email}")
    public String createPost(@ModelAttribute Post post, @PathVariable("email") String email){
        postService.savePost(post, email);
        return "home";
    }
}
