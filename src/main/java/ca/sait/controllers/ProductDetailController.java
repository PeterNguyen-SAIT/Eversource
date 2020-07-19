
package ca.sait.controllers;

import ca.sait.entity.ProductsEntity;
import ca.sait.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class ProductDetailController {
    @Autowired
    private ProductsService productsService;

    @GetMapping("/productDetail")
    public String showEventPage(Long productId, ModelMap model) {
        ProductsEntity productsEntity = productsService.getById(productId);
        model.addAttribute("productsEntity", productsEntity);
        return "customer/shop-details";
    }
}