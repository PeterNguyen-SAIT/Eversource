package ca.sait.controllers;

import ca.sait.service.UsersService;
import ca.sait.service.impl.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class AdminController {


    @RequestMapping("/admin")
    public String admin(Model model) {
        return "admin";
    }




}
