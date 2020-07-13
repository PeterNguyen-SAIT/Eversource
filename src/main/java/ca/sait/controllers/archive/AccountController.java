package ca.sait.controllers.archive;

import ca.sait.service.impl.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

    @Autowired
    private UsersServiceImpl userService;

//    @GetMapping("/account")
//    public String showLoginPage(ModelMap model) {
//        UsersEntity user = new UsersEntity();
//        model.addAttribute("usersEntity",user);
//        return "customer/account";
//    }

//    @PostMapping("/login")
//    public String submitForm(@ModelAttribute("usersEntity") UsersEntity usersEntity) {
//        //System.out.println(usersEntity);
//        List<UsersEntity> allUsers = userService.list();
//
//        QueryWrapper<UsersEntity> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("uname", usersEntity.getUname());
//        UsersEntity userLoggedIn = userService.getOne(queryWrapper);
//
//        if (userLoggedIn==null)
//        {
//            return "redirect:/invalidUser";
//        }
//        else
//        {
//            if(usersEntity.getPassword().equals(userLoggedIn.getPassword()))
//            {
//                if(userLoggedIn.getRole().equals("admin"))
//                {
//                    return "admin/index";
//                }
//                else
//                {
//                    return "customer/loginsuccess";
//                }
//            }
//            else
//            {
//                return "redirect:/invalidUser";
//            }
//
//
//        }
////                && loginCheck.getPassword().equals(userEntity.getPassword())) {
////            if (loginCheck.getIsCustomer() == 1) {
////                return "homepage";
////            } else if (loginCheck.getIsCustomer() == 0) {
////                return "redirect:/admin";
////            } else {
////                return "login";
////            }
////        } else {
////            //model.addAttribute("loginError", "Error logging in");
//
////        }
//    }
//    @RequestMapping("/invalidUser")
//    public String showError(ModelMap model) {
//        model.addAttribute("message","Invalid login credentials");
//        model.addAttribute("usersEntity",new UsersEntity());
//        return "customer/login";
//    }
////    }
}