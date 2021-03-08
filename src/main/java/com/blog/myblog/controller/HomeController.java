package com.blog.myblog.controller;

import com.blog.myblog.domain.User;
import com.blog.myblog.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class HomeController {

    private HomeService homeService;

    @Autowired
    public void setHomeService(HomeService homeService) { this.homeService = homeService; }

    @GetMapping("/user/")
    public List<User> getUsers(){
        return homeService.getUsers();
    }
    @GetMapping("/")
    public String getHome(){
        return homeService.getHome();
    }

    @GetMapping("/admin/")
    public String getAdmin() { return homeService.getAdmin(); }
}
