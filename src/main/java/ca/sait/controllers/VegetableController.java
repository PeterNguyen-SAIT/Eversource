package ca.sait.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class VegetableController {
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/vegetable")
//    public String showForm(Model model) {
//        ProductEntity productEntity = new ProductEntity();
//        List<ProductEntity> products = new ArrayList<>();
//
//        model.addAttribute("productEntity", productEntity);
//        model.addAttribute("products", products);
//        return "vegetable";
//    }
//
//    @PostMapping("/vegetable")
//    public String submitForm(@ModelAttribute("userEntity") UserEntity userEntity) {
//        System.out.println(userEntity);
//        UserEntity loginCheck = userService.loginUser(userEntity.getEmail(), userEntity.getPassword());
//        System.out.println(loginCheck);
//
//        if (loginCheck.getEmail().equals(userEntity.getEmail())
//                && loginCheck.getPassword().equals(userEntity.getPassword())) {
//            return "homepage";
//        } else {
//            return "login";
//        }
//    }
}
