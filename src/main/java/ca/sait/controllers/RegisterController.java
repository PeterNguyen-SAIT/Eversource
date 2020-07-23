package ca.sait.controllers;


import ca.sait.entity.UsersEntity;
import ca.sait.service.GmailService;
import ca.sait.service.impl.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ca.sait.entity.UsersEntity;

import java.util.HashMap;
import java.util.UUID;

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
        usersEntity.setStatus("inactive");
        userService.saveOrUpdate(usersEntity);
        model.addAttribute("message","Activation message sent. Check your inbox and activate your account to login.");
        model.addAttribute("usersEntity",new UsersEntity());

        String uuid = UUID.randomUUID().toString();
        String url="http://localhost:8080/activate?username="+usersEntity.getUname();
        String link = url + "&uuid=" + uuid;
        String subject = "Activate Account";
            String template = "src\\main\\resources\\templates\\customer\\accountactivation.html" ;
            HashMap<String, String> tags = new HashMap<>();
            tags.put("username", usersEntity.getUname());

            tags.put("link", link);
            GmailService.sendMail1(usersEntity.getEmail(), subject, template, tags);
        return "customer/login";
    }

}
