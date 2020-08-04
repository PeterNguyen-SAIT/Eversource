package ca.sait.controllers;

import ca.sait.entity.UsersEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Blog controller containing 6 static html files.
 * Also stores username session and attributes
 * @author Melody Zhang
 */
@Controller
public class BlogController {

    /**
     * Stores username session attribute and display main blog page containing all 6 static blogs.
     * @param model
     * @param session
     * @return blog.html
     */
    @GetMapping("/blog")
    public String showBlogPage(ModelMap model, HttpSession session) {

            String username = (String) session.getAttribute("username");
            model.addAttribute("loggedIn", " " + username);
            model.addAttribute("usernameExist", username);
            return "customer/blog";

    }

    // July 24 temp controller for blog-sub pages

    /**
     * First static blog
     * @param model
     * @param session
     * @return blog1.html
     */
    @GetMapping("/blog1")
    public String showBlogPage1(ModelMap model, HttpSession session) {

        String username = (String) session.getAttribute("username");
        model.addAttribute("loggedIn", " " + username);
        model.addAttribute("usernameExist", username);
        return "customer/blog1";

    }

    /**
     * Second static blog
     * @param model
     * @param session
     * @return blog2.html
     */
    @GetMapping("/blog2")
    public String showBlogPage2(ModelMap model, HttpSession session) {

        String username = (String) session.getAttribute("username");
        model.addAttribute("loggedIn", " " + username);
        model.addAttribute("usernameExist", username);
        return "customer/blog2";

    }

    /**
     * Third static blog
     * @param model
     * @param session
     * @return blog3.html
     */
    @GetMapping("/blog3")
    public String showBlogPage3(ModelMap model, HttpSession session) {

        String username = (String) session.getAttribute("username");
        model.addAttribute("loggedIn", " " + username);
        model.addAttribute("usernameExist", username);
        return "customer/blog3";

    }

    /**
     * Fourth static blog
     * @param model
     * @param session
     * @return blog4.html
     */
    @GetMapping("/blog4")
    public String showBlogPage4(ModelMap model, HttpSession session) {

        String username = (String) session.getAttribute("username");
        model.addAttribute("loggedIn", " " + username);
        model.addAttribute("usernameExist", username);
        return "customer/blog4";

    }

    /**
     * Fifth static blog
     * @param model
     * @param session
     * @return blog5.html
     */
    @GetMapping("/blog5")
    public String showBlogPage5(ModelMap model, HttpSession session) {

        String username = (String) session.getAttribute("username");
        model.addAttribute("loggedIn", " " + username);
        model.addAttribute("usernameExist", username);
        return "customer/blog5";

    }

    /**
     * Sixth static blog
     * @param model
     * @param session
     * @return blog6.html
     */
    @GetMapping("/blog6")
    public String showBlogPage6(ModelMap model, HttpSession session) {

        String username = (String) session.getAttribute("username");
        model.addAttribute("loggedIn", " " + username);
        model.addAttribute("usernameExist", username);
        return "customer/blog6";

    }


}
