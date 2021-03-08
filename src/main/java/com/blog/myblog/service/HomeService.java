package com.blog.myblog.service;

import com.blog.myblog.domain.User;
import com.blog.myblog.repository.UserRepository;
import com.blog.myblog.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    public User findByEmail(String email){
        return usersTable.findByEmail(email);
    }
}
