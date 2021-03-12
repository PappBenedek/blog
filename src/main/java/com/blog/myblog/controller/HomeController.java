package com.blog.myblog.controller;

import com.blog.myblog.domain.Role;
import com.blog.myblog.domain.User;
import com.blog.myblog.repository.RoleRepository;
import com.blog.myblog.repository.UserRepository;
import com.blog.myblog.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class HomeController {

    private HomeService homeService;
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public HomeController(UserRepository userRepository) { this.userRepository = userRepository; }
    @Autowired
    public void setHomeService(HomeService homeService) { this.homeService = homeService; }
    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) { this.roleRepository = roleRepository; }
    @GetMapping("/")
    public String getHome(){
        return homeService.getHome();
    }

    @GetMapping("/registration")
    public String getRegistration(Model model){
        model.addAttribute("user", new User());
        return homeService.getRegistration();
    }
    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }
    @PostMapping("/reg")
    public String subReg(@ModelAttribute User user){
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByRole("ROLE_USER"));
        user.setRoles(roles);
        userRepository.save(user);
        return homeService.getRegistration();
    }
    @GetMapping("/manageusers")
    public String getManageUsers(Model model){
        List<User> users = userRepository.findAll();
        model.addAttribute("users",users);
        return "manageusers";
    }

    @GetMapping("/manageusers/{email}")
    public String getSpecificUser(@PathVariable String email, Model model){
        User user = userRepository.findByEmail(email);
        model.addAttribute("user", user);
        model.addAttribute("roles", user.getRoles().stream().map(s -> s.getRole()).toArray());
        return "specificuser";
    }
}
