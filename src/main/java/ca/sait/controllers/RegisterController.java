package ca.sait.controllers;

import ca.sait.entity.UsersEntity;
import ca.sait.service.impl.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {

    @Autowired
    private UsersServiceImpl userService;

    @GetMapping("/register")
    public String showForm(Model model) {
        UsersEntity usersEntity = new UsersEntity();
        model.addAttribute("userEntity", usersEntity);

        return "register";
    }

    @PostMapping("/register")
    public String submitForm(@ModelAttribute("userEntity") UsersEntity usersEntity) {
        System.out.println(usersEntity);
        userService.saveOrUpdate(usersEntity);
        return "registerSuccess";
    }

}
