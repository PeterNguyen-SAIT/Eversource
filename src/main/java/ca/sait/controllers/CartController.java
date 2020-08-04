package ca.sait.controllers;

import ca.sait.entity.OrdersEntity;
import ca.sait.entity.ProductsEntity;
import ca.sait.entity.UsersEntity;
import ca.sait.service.OrdersService;
import ca.sait.service.ProductsService;
import ca.sait.service.impl.OrdersServiceImpl;
import ca.sait.service.impl.ProductsServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody; //*************** July 22

import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Cart controller class, handles ordering items, changing item quantities and displaying items
 */
@Controller
public class CartController {

    @Autowired
    OrdersServiceImpl ordersService;

    @Autowired
    ProductsServiceImpl productsService;

    private DecimalFormat df = new DecimalFormat("0.00");

    /**
     * Go to shopping cart page, loads all user's orders and calculating price
     * @param model model map
     * @param session http session storage
     * @return the view
     */
    @GetMapping("/shoppingcart")
    public String showCartPage(ModelMap model, HttpSession session) {
        String username = (String) session.getAttribute("username");

        model.addAttribute("loggedIn", " " + username);
        model.addAttribute("usernameExist", username);
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

        session.setAttribute("cartTotal", finalAfterFormat);

        return "customer/shop-cart";
    }

    /**
     * Go to item details by clicking on the item image or name
     * @param model model map
     * @param session http session storage
     * @return the view
     */
    @GetMapping("/shopdetail")
    public String showDetail(ModelMap model, HttpSession session) {
        String username = (String) session.getAttribute("username");
        if (username == null || username.equals("")) {

        } else {
            model.addAttribute("loggedIn", " " + username);
        }
        model.addAttribute("usernameExist", username);
        return "customer/shop-details";
    }

    /**
     * Ordering an item, receive the quantity and proceed that item into cart
     * @param amount the quantity of the ordered item
     * @param oid the order id
     * @param model model map
     * @param session http session storage
     * @return the view
     */
    @PostMapping("/cart")
    public String updateOrder(@RequestParam int amount, @RequestParam int oid, ModelMap model, HttpSession session) {
        OrdersEntity updatedOrder = ordersService.getById(oid);
        if (updatedOrder == null) {
            model.addAttribute("message", "Error: Order doesn't exist. Please refresh page");
            return "customer/shop-cart";
        } else {

            if (amount == 0) {
                ordersService.removeById(oid);
                model.addAttribute("message", "Item removed.");
            } else {


                QueryWrapper<ProductsEntity> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("pname", updatedOrder.getPname());
                ProductsEntity product = productsService.getOne(queryWrapper);
                if (amount > product.getStock()) {
                    model.addAttribute("message", "Amount exceeds stock. Stock: " + product.getStock() + " " + product.getUnit());
                } else {
                    updatedOrder.setQuantity(amount);
                    if (ordersService.saveOrUpdate(updatedOrder)) {
                        model.addAttribute("message", "Updated.");
                    } else {
                        model.addAttribute("message", "Failed to update. Please contact developers for assistance");
                    }
                }
            }
        }
        String username = (String) session.getAttribute("username");
        List<OrdersEntity> allOrders = ordersService.list();
        ArrayList<OrdersEntity> allCurrentCustomerOrder = new ArrayList<>();
        double total = 0;
        double gst = 0;
        double finalTotal = 0;
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
        gst = (total * 5) / 100;
        String gstAfterFormat = df.format(gst);
        finalTotal = total + gst;
        String finalAfterFormat = df.format(finalTotal);

        model.addAttribute("orderArrayList", allCurrentCustomerOrder);
        model.addAttribute("total", "$" + totalAfterFormat);
        model.addAttribute("gst", "$" + gstAfterFormat);
        model.addAttribute("finalTotal", "$" + finalAfterFormat);

        session.setAttribute("cartTotal", finalAfterFormat);

        model.addAttribute("orderArrayList", allCurrentCustomerOrder);
        model.addAttribute("loggedIn", " " + username);
        model.addAttribute("usernameExist", username);
        return "customer/shop-cart";
    }


    /**
     * Edit the quantity of the items.
     * @param amount the new quantity
     * @param oid the order id
     * @param session http session storage
     * @return the view
     */
    //July 23
    @ResponseBody
    @PostMapping("/cartEdit")
    public Map<String, Object> cartEdit(@RequestParam int amount, @RequestParam int oid,HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        OrdersEntity updatedOrder = ordersService.getById(oid);
        map.put("code",200);
        if (updatedOrder == null) {
            map.put("msg", "Error: Order doesn't exist. Please refresh page");
            return map;
        } else {

            if (amount == 0) {
                ordersService.removeById(oid);
                map.put("msg", "Item removed.");
            } else {
                QueryWrapper<ProductsEntity> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("pname", updatedOrder.getPname());
                ProductsEntity product = productsService.getOne(queryWrapper);
                if (amount > product.getStock()) {
                    map.put("code",500);
                    map.put("max",product.getStock());
                    map.put("msg", "Amount exceeds stock. Stock: " + product.getStock() + " " + product.getUnit());
                } else {
                    updatedOrder.setQuantity(amount);
                    if (ordersService.saveOrUpdate(updatedOrder)) {
                        map.put("msg","Updated.");
                    } else {
                        map.put("msg", "Failed to update. Please contact developers for assistance");
                    }
                }
            }
        }
        String username = (String) session.getAttribute("username");
        List<OrdersEntity> allOrders = ordersService.list();
        ArrayList<OrdersEntity> allCurrentCustomerOrder = new ArrayList<>();
//        double total = 0;
//        double gst = 0;
//        double finalTotal = 0;
        for (OrdersEntity order : allOrders) {
            if (order.getUname().equals(username)) {

                allCurrentCustomerOrder.add(order);
//                total += order.getPrice() * order.getQuantity();
            }
        }
        for (OrdersEntity order : allCurrentCustomerOrder) {
            QueryWrapper<ProductsEntity> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("pname", order.getPname());
            ProductsEntity product = productsService.getOne(queryWrapper);
            if (product == null) {
                map.put("msg", "Error updating image for product" + "\n" + "Please contact developers for assistance.");

            } else {
                if (order.getImage() != null) {

                } else {
                    order.setImage(product.getImage());
                    if (ordersService.saveOrUpdate(order)) {

                    } else {
                        map.put("msg", "Error updating image for product. Please contact developers for assistance.");
                    }
                }
            }
        }
//        String totalAfterFormat = df.format(total);
//        gst = (total * 5) / 100;
//        String gstAfterFormat = df.format(gst);
//        finalTotal = total + gst;
//        String finalAfterFormat = df.format(finalTotal);

//        model.addAttribute("orderArrayList", allCurrentCustomerOrder);
//        model.addAttribute("total", "$" + totalAfterFormat);
//        model.addAttribute("gst", "$" + gstAfterFormat);
//        model.addAttribute("finalTotal", "$" + finalAfterFormat);
//
//        model.addAttribute("orderArrayList", allCurrentCustomerOrder);
//        model.addAttribute("loggedIn", " " + username);
//        model.addAttribute("usernameExist", username);
        return map;
    }

    /**
     * Delete an item from the cart, by setting the quantity into 0
     * @param oid the order id
     * @param model model map
     * @param session http session storage
     * @return the view
     */
    @PostMapping("/deleteOrder")
    public String updateOrder(@RequestParam int oid, ModelMap model, HttpSession session) {
        String username = (String) session.getAttribute("username");
        model.addAttribute("loggedIn", " " + username);
        model.addAttribute("usernameExist", username);
        OrdersEntity updatedOrder = ordersService.getById(oid);
        if (updatedOrder == null) {
            model.addAttribute("message", "Error: Order doesn't exist. Please refresh page");
        } else {
            if (ordersService.removeById(oid)) {
                model.addAttribute("message", "Order deleted.");
            } else {
                model.addAttribute("message", "Failed to delete order. Please contact developers for assistance.");

            }
        }

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

        session.setAttribute("cartTotal", finalAfterFormat);

        return "customer/shop-cart";

    }


}
