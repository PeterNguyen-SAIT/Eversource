package ca.sait.controllers;

import ca.sait.entity.UsersEntity;
import ca.sait.service.impl.UsersServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Login controller class
 * @author Huy Nguyen, Peter Nguyen
 */
@Controller
public class LoginController {

    @Autowired
    private UsersServiceImpl userService;


    /**
     * Create and store userEntity in html (empty)
     *
     * @param model
     * @return login.html
     */
    @GetMapping("/login")
    public String showLoginPage(ModelMap model) {
        UsersEntity user = new UsersEntity();
        model.addAttribute("usersEntity", user);
        return "customer/login";
    }

    /**
     * Checks if user input is valid with database.
     * If successful username is stored in session.
     * If unsucessful user is redirected back to login.html with message
     * @param usersEntity
     * @param model
     * @param session
     * @return loginsucess.html
     */
    @PostMapping("/login")
    public String submitForm(@ModelAttribute("usersEntity") UsersEntity usersEntity, ModelMap model, HttpSession session) {
        List<UsersEntity> allUsers = userService.list();

        QueryWrapper<UsersEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uname", usersEntity.getUname());
        UsersEntity userLoggedIn = userService.getOne(queryWrapper);

        if (userLoggedIn == null) {
            return "redirect:/invalidUser";
        } else {
            if (usersEntity.getPassword().equals(userLoggedIn.getPassword())) {
                if (userLoggedIn.getStatus() == null || !userLoggedIn.getStatus().equals("active")) {
                    return "redirect:/invalidUser";
                } else {
                    session.setAttribute("username", userLoggedIn.getUname());
                    model.addAttribute("loggedIn", " " + session.getAttribute("username"));
                    return "customer/loginsuccess";
                }
            } else {
                return "redirect:/invalidUser";
            }
        }
    }

    /**
     * Send message to login.html with invalid user input message
     * @param model
     * @return login.html
     */
    @RequestMapping("/invalidUser")
    public String showError(ModelMap model) {
        model.addAttribute("message", "Invalid login credentials");
        model.addAttribute("usersEntity", new UsersEntity());
        return "customer/login";
    }

    /**
     * Invalidate the session and redirects back to index.html
     * @param model
     * @param session
     * @return index.html
     */
    @GetMapping("/logout")
    public String logout(ModelMap model, HttpSession session) {
        model.addAttribute("message", "Logout successfully");
        session.invalidate();
        model.addAttribute("usersEntity", new UsersEntity());
        return "customer/index";
    }
}