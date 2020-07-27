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

            String username = (String) session.getAttribute("username");
            model.addAttribute("loggedIn", " " + username);
            model.addAttribute("usernameExist", username);
            return "customer/blog";

    }
    // July 24 temp controller for blog-sub pages
    @GetMapping("/blog1")
    public String showBlogPage1(ModelMap model, HttpSession session) {

        String username = (String) session.getAttribute("username");
        model.addAttribute("loggedIn", " " + username);
        model.addAttribute("usernameExist", username);
        return "customer/blog1";

    }

    @GetMapping("/blog2")
    public String showBlogPage2(ModelMap model, HttpSession session) {

        String username = (String) session.getAttribute("username");
        model.addAttribute("loggedIn", " " + username);
        model.addAttribute("usernameExist", username);
        return "customer/blog2";

    }

    @GetMapping("/blog3")
    public String showBlogPage3(ModelMap model, HttpSession session) {

        String username = (String) session.getAttribute("username");
        model.addAttribute("loggedIn", " " + username);
        model.addAttribute("usernameExist", username);
        return "customer/blog3";

    }

    @GetMapping("/blog4")
    public String showBlogPage4(ModelMap model, HttpSession session) {

        String username = (String) session.getAttribute("username");
        model.addAttribute("loggedIn", " " + username);
        model.addAttribute("usernameExist", username);
        return "customer/blog4";

    }

    @GetMapping("/blog5")
    public String showBlogPage5(ModelMap model, HttpSession session) {

        String username = (String) session.getAttribute("username");
        model.addAttribute("loggedIn", " " + username);
        model.addAttribute("usernameExist", username);
        return "customer/blog5";

    }

    @GetMapping("/blog6")
    public String showBlogPage6(ModelMap model, HttpSession session) {

        String username = (String) session.getAttribute("username");
        model.addAttribute("loggedIn", " " + username);
        model.addAttribute("usernameExist", username);
        return "customer/blog6";

    }


}
