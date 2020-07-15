package ca.sait.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CartController {

    @GetMapping("/shoppingcart")
    public String showContactPage(ModelMap model, HttpSession session) {
        model.addAttribute("loggedIn","Hello "+session.getAttribute("username"));
        return "customer/shop-cart";
    }


}
