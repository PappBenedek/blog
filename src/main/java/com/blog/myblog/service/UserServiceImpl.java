package com.blog.myblog.service;

import com.blog.myblog.domain.User;
import com.blog.myblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {
    private UserRepository usersTable;
    @Autowired
    public void setUsersTable(UserRepository usersTable) {
        this.usersTable = usersTable;
    }

    @Override
    public User findByEmail(String email) {
        return usersTable.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = findByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException(email);
        }
        return new UserDetailsImpl(user);
    }
}
