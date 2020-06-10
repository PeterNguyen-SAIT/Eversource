package com.example2.controllers;

import com.example2.entity.UserEntity;
import com.example2.model.Customer;
import com.example2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showForm(Model model) {
        UserEntity userEntity = new UserEntity();
        model.addAttribute("userEntity", userEntity);

        return "register";
    }

    @PostMapping("/register")
    public String submitForm(@ModelAttribute("userEntity") UserEntity userEntity) {
        System.out.println(userEntity);
        userService.insertUser(userEntity);
        return "registerSuccess";
    }

}
