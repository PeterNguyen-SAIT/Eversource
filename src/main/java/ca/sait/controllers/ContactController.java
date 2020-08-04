package ca.sait.controllers;

import ca.sait.entity.UsersEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * Contact controller class to redirect pages into contact page
 */
@Controller
public class ContactController {
    /**
     * Go to contact page
     * @param model
     * @param session
     * @return
     */
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
        model.addAttribute("usersEntity",new UsersEntity());
        model.addAttribute("usernameExist",username);
        return "customer/contact";
    }

    /**
     * Send an email to the admin with the form in contact page
     * @param model
     * @param content
     * @param usersEntity
     * @return
     */
    @PostMapping("/contact")
    public String sendContentMail(ModelMap model, String content, UsersEntity usersEntity) {
        return "test/errorPage_404";
    }


}
