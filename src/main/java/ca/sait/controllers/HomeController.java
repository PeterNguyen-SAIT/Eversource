package ca.sait.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String homepage() {
        return "customer/index";
    }

    @RequestMapping("/homepage")
    public String home(Model model) {
        return "homepage";
    }
}
