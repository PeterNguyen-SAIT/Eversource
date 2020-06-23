package ca.sait.controllers;

import ca.sait.entity.UsersEntity;
import ca.sait.service.impl.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UsersServiceImpl userService;
//
//    @GetMapping("/login")
//    public String showForm(Model model) {
//        UserEntity userEntity = new UserEntity();
//        model.addAttribute("userEntity", userEntity);
//        return "login";
//    }
//
//    @PostMapping("/login")
//    public String submitForm(@ModelAttribute("userEntity") UsersEntity userEntity) {
//        //System.out.println(userEntity);
//        List<UsersEntity> allUsers = userService.list();
//        for(UsersEntity user: allUsers)
//        {
//            if()
//            {
//
//            }
//        }
//        if (loginCheck == null) {
//            return "redirect:/invalidUser";
//
//        } else if (loginCheck.getEmail().equals(userEntity.getEmail())
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
//            return "login";
//        }
//    }
//    @RequestMapping("/invalidUser")
//    public String showError(ModelMap model) {
//        model.addAttribute("message","Invalid login credentials");
//        model.addAttribute("userEntity",new UserEntity());
//        return "login";
//    }
    }

