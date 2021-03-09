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
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashSet;
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
    @PostMapping("/reg")
    public String subReg(@ModelAttribute User user){
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByRole("ROLE_USER"));
        user.setRoles(roles);
        userRepository.save(user);
        return homeService.getRegistration();
    }
}
