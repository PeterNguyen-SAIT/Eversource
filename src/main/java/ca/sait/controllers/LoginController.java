package ca.sait.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/login")
//    public String showForm(Model model) {
//        UserEntity userEntity = new UserEntity();
//        model.addAttribute("userEntity", userEntity);
//        return "login";
//    }
//
//    @PostMapping("/login")
//    public String submitForm(@ModelAttribute("userEntity") UserEntity userEntity) {
//        //System.out.println(userEntity);
//        UserEntity loginCheck = userService.loginUser(userEntity.getEmail(), userEntity.getPassword());
//        System.out.println(loginCheck);
//
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

