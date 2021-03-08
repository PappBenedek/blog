package com.blog.myblog.service;

import com.blog.myblog.domain.User;

public interface UserService {
    public User findByEmail(String email);
}
