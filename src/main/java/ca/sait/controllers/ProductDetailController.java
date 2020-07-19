
package ca.sait.controllers;

import ca.sait.entity.ProductsEntity;
import ca.sait.service.ProductsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class ProductDetailController {
    @Autowired
    private ProductsService productsService;

    @GetMapping("/productDetail")
    public String showEventPage(Long productId, ModelMap model, String productName) {
        ProductsEntity productsEntity=null;
        if(productId!=null)
        {
            productsEntity = productsService.getById(productId);
        }
        else
            if(productName!=null)
        {
            QueryWrapper<ProductsEntity> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("pname", productName);
            productsEntity = productsService.getOne(queryWrapper);
        }


        model.addAttribute("productsEntity", productsEntity);
        return "customer/shop-details";
    }
}