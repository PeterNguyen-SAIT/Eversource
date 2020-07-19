package ca.sait.controllers;

import ca.sait.entity.OrdersEntity;
import ca.sait.entity.ProductsEntity;
import ca.sait.service.impl.OrdersServiceImpl;
import ca.sait.service.impl.ProductsServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ca.sait.entity.ProductsEntity;
import ca.sait.entity.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;


@Controller
public class VegetableController {

    @Autowired
    private ProductsServiceImpl productsService;

    @Autowired
    private OrdersServiceImpl ordersService;

    @GetMapping("/product")
    public String showForm(Model model, HttpSession session) {
            String username = (String)session.getAttribute("username");
            List<ProductsEntity> productsEntityList = productsService.list();
            model.addAttribute("productsEntityList", productsEntityList);
            model.addAttribute("loggedIn"," "+username);
            model.addAttribute("usernameExist", username);
            return "customer/product";


    }

    @PostMapping("/productId")
    public String submitForm(@RequestParam int productSource, @RequestParam int productQuantity, Model model, HttpSession session) {
        String username = (String)session.getAttribute("username");
        if(username==null || username.equals(""))
        {
            model.addAttribute("message","Please login first");
            model.addAttribute("usersEntity", new UsersEntity());
            return "customer/login";
        }
        else {

            ProductsEntity productsEntity = productsService.getById(productSource);

            if (productQuantity > productsEntity.getStock()) {
                model.addAttribute("message","Amount exceeds stock. Stock: "+productsEntity.getStock()+ " "+productsEntity.getUnit());
            } else {
                OrdersEntity oldOrder = null;
                List<OrdersEntity> allOrders = ordersService.list();
                boolean productExist=false;
                for(OrdersEntity order: allOrders)
                {
                    if(productsEntity.getPname().equals(order.getPname()))
                    {
                        productExist=true;
                        oldOrder = order;
                        break;
                    }
                }
                if(productExist)
                {
                    int currentQuantity = oldOrder.getQuantity();
                    oldOrder.setQuantity(currentQuantity+productQuantity);
                    if(oldOrder.getImage()!=null)
                    {

                    }
                    else
                    {
                        QueryWrapper<ProductsEntity> queryWrapper = new QueryWrapper<>();
                        queryWrapper.eq("pname", oldOrder.getPname());
                        ProductsEntity product = productsService.getOne(queryWrapper);
                        oldOrder.setImage(product.getImage());
                    }
                    if (ordersService.saveOrUpdate(oldOrder)) {
                        model.addAttribute("message", "Added " + productQuantity + " " + productsEntity.getUnit() + " of " + productsEntity.getPname() + " to cart.");

                    } else {
                        model.addAttribute("message", "Failed to add, please contact developers for assistance");
                    }
                }
                else {
                    int newOID = allOrders.size() + 1;

                    OrdersEntity newOrder = new OrdersEntity();
                    newOrder.setUnit(productsEntity.getUnit());
                    newOrder.setQuantity(productQuantity);
                    newOrder.setUname(username);
                    newOrder.setPname(productsEntity.getPname());
                    newOrder.setPrice(productsEntity.getPrice());
                    newOrder.setStatus("hold");
                    boolean inOrder = true;
                    for (int i = 1; i <= allOrders.size(); i++) {
                        if (i != allOrders.get(i - 1).getOid()) {
                            newOrder.setOid(i);
                            inOrder = false;
                            break;
                        }
                    }

                    if (inOrder) {
                        newOrder.setOid(newOID);
                    }

                    if (ordersService.save(newOrder)) {
                        model.addAttribute("message", "Added " + productQuantity + " " + productsEntity.getUnit() + " of " + productsEntity.getPname() + " to cart.");

                    } else {
                        model.addAttribute("message", "Failed to add, please contact developers for assistance");
                    }
                }
            }
                List<ProductsEntity> productsEntityList = productsService.list();
                model.addAttribute("productsEntityList", productsEntityList);
                model.addAttribute("loggedIn", " " + username);
                model.addAttribute("usernameExist", " " + username);
                return "customer/product";
            }

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
        model.addAttribute("usernameExist"," "+session.getAttribute("username"));
        return "customer/history";
    }
}
