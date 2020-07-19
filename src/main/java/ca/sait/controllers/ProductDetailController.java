
package ca.sait.controllers;

import ca.sait.entity.ProductsEntity;
import ca.sait.service.ProductsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;


@Controller
public class ProductDetailController {
    @Autowired
    private ProductsService productsService;

    @GetMapping("/productDetail")
    public String showEventPage(Long productId, ModelMap model, String productName, HttpSession session) {
        String username = (String) session.getAttribute("username");
        model.addAttribute("loggedIn", " "+username);
        model.addAttribute("usernameExist",username);
        ProductsEntity productsEntity=null;
        if(productId!=null)
        {
            productsEntity = productsService.getById(productId);
            productsEntity.setDiscount(productsEntity.getDiscount()*100);
        }
        else
            if(productName!=null)
        {
            QueryWrapper<ProductsEntity> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("pname", productName);
            productsEntity = productsService.getOne(queryWrapper);
            productsEntity.setDiscount(productsEntity.getDiscount()*100);
        }


        model.addAttribute("productsEntity", productsEntity);
        return "customer/shop-details";
    }
}