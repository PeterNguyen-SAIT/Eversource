package ca.sait.controllers;

import ca.sait.entity.Order;
import ca.sait.entity.OrdersEntity;
import ca.sait.entity.ProductsEntity;
import ca.sait.service.PaypalService;
import ca.sait.service.impl.OrdersServiceImpl;
import ca.sait.service.impl.ProductsServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
class PaypalController {

    @Autowired
    PaypalService service;

    @Autowired
    OrdersServiceImpl ordersService;

    @Autowired
    ProductsServiceImpl productsService;

    private DecimalFormat df = new DecimalFormat("0.00");

    public static final String SUCCESS_URL = "pay/success";
    public static final String CANCEL_URL = "pay/cancel";

    @PostMapping("/pay")
    public String payment(HttpSession session) {
        String price1 = (String) session.getAttribute("cartTotal");
        double price = Double.parseDouble(price1);
        try {
            Payment payment = service.createPayment(price, "CAD", "paypal",
                    "sale", "delivery", "http://localhost:8080/" + CANCEL_URL,
                    "http://localhost:8080/" + SUCCESS_URL);
            for(Links link:payment.getLinks()) {
                if(link.getRel().equals("approval_url")) {
                    return "redirect:"+link.getHref();
                }
            }

        } catch (PayPalRESTException e) {

            e.printStackTrace();
        }
        return "redirect:/";
    }

    @GetMapping(value = CANCEL_URL)
    public String cancelPay() {
        return "test/cancel";
    }

    @GetMapping(value = SUCCESS_URL)
    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
        try {
            Payment payment = service.executePayment(paymentId, payerId);
            System.out.println(payment.toJSON());
            if (payment.getState().equals("approved")) {
                return "home";
            }
        } catch (PayPalRESTException e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/";
    }
}