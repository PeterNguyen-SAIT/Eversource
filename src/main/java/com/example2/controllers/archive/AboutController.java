package com.example2.controllers.archive;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutController {

    @RequestMapping("/about")
    public String about(Model model) {
        model.addAttribute("welcome", "Greeting");
        return "archive/about";
    }
}
