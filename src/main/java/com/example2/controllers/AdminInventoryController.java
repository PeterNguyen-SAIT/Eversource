package com.example2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminInventoryController {
    @RequestMapping("/homepage")
    public String adminInventory(Model model) {
        return "homepage";
    }
}
