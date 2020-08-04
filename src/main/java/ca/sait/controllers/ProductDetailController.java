
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

/**
 * Product detail controller to redirect from pages into the product detail page
 */
@Controller
public class ProductDetailController {
    @Autowired
    private ProductsService productsService;

    /**
     * Go to product detail page, based on the id received when the user clicks on the images, redirect them to the corresponding product
     * @param productId the id of the product the user clicks on
     * @param model model map
     * @param productName name of the product
     * @param session session storage
     * @return the view
     */
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