package ca.sait.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Home controller to redirect pages into the home page
 */
@Controller
public class HomeController {
    /**
     * Home mapping, go to homepage
     * @param model model map
     * @param session session storage
     * @return the view
     */
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

    /**
     * Default mapping, go to index page whenever the project is loaded or refreshed
     * @param model model map
     * @param session http session storage
     * @return the view
     */
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
