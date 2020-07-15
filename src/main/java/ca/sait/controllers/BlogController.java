package ca.sait.controllers;

import ca.sait.entity.UsersEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class BlogController {

    @GetMapping("/blog")
    public String showBlogPage(ModelMap model, HttpSession session) {
        if (session.getAttribute("username") == null) {
            model.addAttribute("message","Please login first");
            model.addAttribute("usersEntity",new UsersEntity());
            return "customer/login";
        } else {
            String username = (String) session.getAttribute("username");
            model.addAttribute("loggedIn", " " + username);
            model.addAttribute("usernameExist", username);
            return "customer/blog";
        }
    }


}
