package com.example2.controllers;

import com.example2.entity.UserEntity;
import com.example2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showForm(Model model) {
        UserEntity userEntity = new UserEntity();
        model.addAttribute("userEntity", userEntity);
        return "login";
    }

    @PostMapping("/login")
    public String submitForm(@ModelAttribute("userEntity") UserEntity userEntity) {
        System.out.println(userEntity);
        UserEntity loginCheck = userService.loginUser(userEntity.getEmail(), userEntity.getPassword());
        System.out.println(loginCheck);

        if (loginCheck.getEmail().equals(userEntity.getEmail())
        && loginCheck.getPassword().equals(userEntity.getPassword())) {
            return "homepage";
        } else {
            //model.addAttribute("loginError", "Error logging in");
            return "login";
        }
    }
}