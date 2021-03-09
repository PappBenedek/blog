package com.blog.myblog.service;

import com.blog.myblog.domain.User;
import com.blog.myblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class HomeService {

    public String getHome(){
        return "home";
    }

    public String getRegistration() {
        return "registration";
    }

}

