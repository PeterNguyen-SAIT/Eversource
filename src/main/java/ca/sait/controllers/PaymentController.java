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

    @PostMapping("/payment")
    public String showPaymentPage(ModelMap model, HttpSession session) {

        String username = (String) session.getAttribute("username");
        double total = 0;
        double gst = 0;
        double finalTotal = 0;
        List<OrdersEntity> allOrders = ordersService.list();
        ArrayList<OrdersEntity> allCurrentCustomerOrder = new ArrayList<>();
        for (OrdersEntity order : allOrders) {
            if (order.getUname().equals(username)) {
                allCurrentCustomerOrder.add(order);
                total += order.getPrice() * order.getQuantity();
            }
        }

        for (OrdersEntity order : allCurrentCustomerOrder) {
            QueryWrapper<ProductsEntity> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("pname", order.getPname());
            ProductsEntity product = productsService.getOne(queryWrapper);
            if (product == null) {
                model.addAttribute("message", "Error updating image for product" + "\n" + "Please contact developers for assistance.");
            } else {
                if (order.getImage() != null) {

                } else {
                    order.setImage(product.getImage());
                    if (ordersService.saveOrUpdate(order)) {

                    } else {
                        model.addAttribute("message", "Error updating image for product. Please contact developers for assistance.");
                    }
                }
            }
            //ProductsEntity product = productsService.getById(order.getPname());
        }
        String totalAfterFormat = df.format(total);
        gst = (Double.parseDouble(totalAfterFormat) * 5.0) / 100.0;
        String gstAfterFormat = df.format(gst);
        finalTotal = total + gst;
        String finalAfterFormat = df.format(finalTotal);

        model.addAttribute("orderArrayList", allCurrentCustomerOrder);
        model.addAttribute("total", "$" + totalAfterFormat);
        model.addAttribute("gst", "$" + gstAfterFormat);
        model.addAttribute("finalTotal", "$" + finalAfterFormat);
        return "test/payment";
    }

    @PostMapping("/pay")
    public String payment(@ModelAttribute("order") Order order) {
        try {
            Payment payment = service.createPayment(order.getPrice(), order.getCurrency(), order.getMethod(),
                    order.getIntent(), order.getDescription(), "http://localhost:8080/" + CANCEL_URL,
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
                return "success";
            }
        } catch (PayPalRESTException e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/";
    }
}