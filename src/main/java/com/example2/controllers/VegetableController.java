package com.example2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VegetableController {
    @RequestMapping("/vegetable")
    public String vegetable(Model model) {
        return "vegetable";
    }
}
