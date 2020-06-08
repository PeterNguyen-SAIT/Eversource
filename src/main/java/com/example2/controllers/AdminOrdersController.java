package com.example2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminOrdersController {
    @RequestMapping("/")
    public String adminOrders(Model model) {
        return "homepage";
    }
}
