package ca.sait.controllers;

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

@Controller
public class LoginController {

    @Autowired
    private UsersServiceImpl userService;


    @GetMapping("/login")
    public String showLoginPage(ModelMap model) {
        UsersEntity user = new UsersEntity();
        model.addAttribute("usersEntity",user);
        return "customer/login";
    }

    @PostMapping("/login")
    public String submitForm(@ModelAttribute("usersEntity") UsersEntity usersEntity, ModelMap model, HttpSession session) {
        //System.out.println(usersEntity);
        List<UsersEntity> allUsers = userService.list();

        QueryWrapper<UsersEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uname", usersEntity.getUname());
        UsersEntity userLoggedIn = userService.getOne(queryWrapper);

        if (userLoggedIn==null)
        {
            return "redirect:/invalidUser";
        }
        else
        {
            if(usersEntity.getPassword().equals(userLoggedIn.getPassword()))
            {
                if(userLoggedIn.getRole().equals("admin"))
                {
                    return "admin/index";
                }
                else
                {
                    session.setAttribute("username",userLoggedIn.getUname());
                    model.addAttribute("loggedIn","Hello "+session.getAttribute("username"));
                    return "customer/loginsuccess";
                }
            }
            else
            {
                return "redirect:/invalidUser";
            }


        }
//                && loginCheck.getPassword().equals(userEntity.getPassword())) {
//            if (loginCheck.getIsCustomer() == 1) {
//                return "homepage";
//            } else if (loginCheck.getIsCustomer() == 0) {
//                return "redirect:/admin";
//            } else {
//                return "login";
//            }
//        } else {
//            //model.addAttribute("loginError", "Error logging in");

//        }
    }
    @RequestMapping("/invalidUser")
    public String showError(ModelMap model) {
        model.addAttribute("message","Invalid login credentials");
        model.addAttribute("usersEntity",new UsersEntity());
        return "customer/login";
    }
    @GetMapping("/logout")
    public String logout(ModelMap model, HttpSession session) {
        model.addAttribute("message","Logout successfully");
        session.invalidate();
        model.addAttribute("usersEntity",new UsersEntity());
        return "customer/index";
    }


//    }
}