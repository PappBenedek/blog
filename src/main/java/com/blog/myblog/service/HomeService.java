package com.blog.myblog.service;

import com.blog.myblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

    private UserRepository usersTable;

    @Autowired
    public void setUsersTable(UserRepository usersTable) { this.usersTable = usersTable; }



}
