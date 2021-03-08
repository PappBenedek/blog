package com.blog.myblog.controller;

import com.blog.myblog.domain.User;
import com.blog.myblog.service.HomeService;
import com.blog.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class HomeController {

    private HomeService homeService;
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) { this.userService = userService; }
    @Autowired
    public void setHomeService(HomeService homeService) { this.homeService = homeService; }

    @GetMapping("/user")
    public String getUsers(){
        return "users";
    }
    @GetMapping("/")
    public String getHome(){
        return homeService.getHome();
    }

    @GetMapping("/admin")
    public String getAdmin() { return homeService.getAdmin(); }
}
