package ca.sait.controllers;

import ca.sait.service.impl.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {

    @Autowired
    private UsersServiceImpl userService;

    @GetMapping("/register")
    public String showForm(Model model) {
        UsersEntity usersEntity = new UsersEntity();
        model.addAttribute("usersEntity", usersEntity);
        return "customer/register";
    }

    @PostMapping("/register")
    public String submitForm(@ModelAttribute("userEntity") UsersEntity usersEntity, ModelMap model) {
        //System.out.println(usersEntity);
        int length = userService.list().size()+1;
        usersEntity.setUid(length);
        usersEntity.setRole("user");
        userService.saveOrUpdate(usersEntity);
        model.addAttribute("message","Register successful, you can now login with your new account");
        model.addAttribute("usersEntity",new UsersEntity());
        return "customer/login";
    }

}
