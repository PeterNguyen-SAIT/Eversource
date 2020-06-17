package ca.sait.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OnlineOrderController {
    @RequestMapping("/online_order")
    public String online_order(Model model) {
        return "online_order";
    }
}
