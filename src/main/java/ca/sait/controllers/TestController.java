package ca.sait.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class TestController {

    @RequestMapping("/test")
    public String index() {
        return "customer/product";
    }


    @GetMapping("/error404")
    public String showErrorPage404(ModelMap model, HttpSession session) {

        String username = (String) session.getAttribute("username");
        model.addAttribute("loggedIn", " " + username);
        model.addAttribute("usernameExist", username);
        return "test/errorPage_404";
    }
    @GetMapping("/backHomefrom404")
    public String showHomeFrom404(ModelMap model, HttpSession session) {

        String username = (String) session.getAttribute("username");
        model.addAttribute("loggedIn", " " + username);
        model.addAttribute("usernameExist", username);
        return "customer/home";
    }



}



