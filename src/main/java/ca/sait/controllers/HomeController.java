package ca.sait.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String homepage(ModelMap model, HttpSession session) {

        String username = (String)session.getAttribute("username");
        if( username == null || username.equals("") )
        {

        }
        else
        {
            model.addAttribute("loggedIn"," "+username);
        }
        model.addAttribute("usernameExist",username);
        return "customer/index";
    }

    @RequestMapping("/homepage")
    public String home(Model model, HttpSession session) {
        String username = (String)session.getAttribute("username");
        if( username == null || username.equals("") )
        {

        }
        else
        {
            model.addAttribute("loggedIn"," "+username);
        }
        model.addAttribute("usernameExist",username);
        return "customer/home";
    }
}
