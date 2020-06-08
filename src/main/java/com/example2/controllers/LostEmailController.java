package com.example2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LostEmailController {

    @RequestMapping("/lost")
    public String recover(Model model) {
        return "recovery";
    }
}

