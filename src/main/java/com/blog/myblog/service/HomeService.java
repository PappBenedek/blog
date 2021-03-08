package com.blog.myblog.service;

import com.blog.myblog.domain.User;
import com.blog.myblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class HomeService {

    private UserRepository usersTable;

    @Autowired
    public void setUsersTable(UserRepository usersTable) { this.usersTable = usersTable; }

    public List<User> getUsers(){
        return usersTable.findAll();
    }

    public String getHome(){
        return "home";
    }

    public String getAdmin() {
        return "admin";
    }
}
