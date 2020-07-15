package ca.sait.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ContactController {

    @GetMapping("/contact")
    public String showContactPage(ModelMap model, HttpSession session) {
        String username = (String)session.getAttribute("username");
        if( username == null || username.equals("") )
        {

        }
        else
        {
            model.addAttribute("loggedIn"," "+username);
        }
        model.addAttribute("usernameExist",username);
        return "customer/contact";
    }


}
