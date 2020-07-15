package ca.sait.controllers;

import ca.sait.entity.OrdersEntity;
import ca.sait.entity.ProductsEntity;
import ca.sait.service.impl.ProductsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ca.sait.entity.ProductsEntity;
import ca.sait.entity.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class VegetableController {

    @Autowired
    private ProductsServiceImpl productsService;

    @GetMapping("/product")
    public String showForm(Model model, HttpSession session) {
        if(session.getAttribute("username") == null)
        {
            model.addAttribute("message","Please login first");
            model.addAttribute("usersEntity",new UsersEntity());
            return "customer/login";
        }
        else
        {
            List<ProductsEntity> productsEntityList = productsService.list();
            model.addAttribute("productsEntityList", productsEntityList);
            model.addAttribute("loggedIn"," "+(String)session.getAttribute("username"));
            return "customer/product";
        }

    }

    @PostMapping("/productId")
    public String submitForm(@RequestParam int productSource, @RequestParam int productQuantity, Model model) {
        System.out.println(productSource);
        System.out.println(productQuantity);
        ProductsEntity productsEntity = productsService.getById(productSource);
        System.out.println(productsEntity);
        List<ProductsEntity> productsEntityList = productsService.list();
        model.addAttribute("productsEntityList", productsEntityList);
        return "customer/product";
    }

    @PostMapping("/productIdGet")
    public String submitForm2(@RequestParam int productSource, @RequestParam int productQuantity,
                              Model model, HttpSession session, HttpServletRequest request) {
        System.out.println(productQuantity);
        ProductsEntity productsEntity = productsService.getById(productSource);
        System.out.println(productsEntity);
        model.addAttribute("hiddenProduct", productSource);
        session.setAttribute("hiddenProduct", productSource);
        return "testing2"; // for order pages
    }

    @PostMapping("/productIdSession")
    public String submitForm3(Model model, HttpSession session, HttpServletRequest request) {
        int productSource = (int) session.getAttribute("hiddenProduct");
        ProductsEntity productsEntity = productsService.getById(productSource);
        OrdersEntity ordersEntity = new OrdersEntity();
        model.addAttribute("sessionId", productSource);
        session.setAttribute("sessionId", productSource);
        return "testing2";
    }

    @GetMapping("/history")
    public String showHistoryPage(ModelMap model, HttpSession session) {
        model.addAttribute("loggedIn"," "+session.getAttribute("username"));
        return "customer/history";
    }
}
