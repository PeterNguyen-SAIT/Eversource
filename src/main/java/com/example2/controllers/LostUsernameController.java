package com.example2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LostUsernameController {

    @RequestMapping("/lost")
    public String recover() {
        return "recovery";
    }


    @RequestMapping("/invalidEmail")
    public String printError(ModelMap model) {
        model.addAttribute("message","Invalid email address");
        return "recovery";
    }
}

