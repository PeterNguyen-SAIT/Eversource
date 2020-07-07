package ca.sait.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {


    public String index() {
        return "test/index";
    }
}
