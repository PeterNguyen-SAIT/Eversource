package com.example2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping("/hello")
    public String sayHello(Model model) {
        System.out.println("Saying hello world Spring boot");
        model.addAttribute("message", "Greeting");
        return "hello";
    }
}
