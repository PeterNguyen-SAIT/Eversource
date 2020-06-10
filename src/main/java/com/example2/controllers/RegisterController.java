package com.example2.controllers;

import com.example2.entity.UserEntity;
import com.example2.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class RegisterController {

    @GetMapping("/register")
    public String showForm(Model model) {
        UserEntity userEntity = new UserEntity();
        model.addAttribute("userEntity", userEntity);

        //Customer customer = new Customer();
        //model.addAttribute("customer", customer);

        return "register";
    }

    @PostMapping("/register")
    public String submitForm(@ModelAttribute("userEntity") UserEntity userEntity) {
        System.out.println(userEntity);
        return "registerSuccess";
    }

}
