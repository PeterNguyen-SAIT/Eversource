package ca.sait.controllers.archive;

import ca.sait.entity.UsersEntity;
import ca.sait.service.UsersService;
import ca.sait.service.impl.UsersServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * Controller for account, user can edit information and save
 */
@Controller
public class AccountController {

    @Autowired
    private UsersServiceImpl userService;

    /**
     * Go to account page from other pages
     * @param model model map
     * @param session http session storage
     * @return the view
     */
    @GetMapping("/account")
    public String showAccountPage(ModelMap model, HttpSession session) {

        if (session.getAttribute("username") == null) {
            model.addAttribute("message", "Please login first");
            model.addAttribute("usersEntity", new UsersEntity());
            return "customer/login";

        } else {
            QueryWrapper<UsersEntity> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("uname", session.getAttribute("username"));
            UsersEntity userLoggedIn = userService.getOne(queryWrapper);
            model.addAttribute("usersEntity", userLoggedIn);
            model.addAttribute("loggedIn", " " + (String) session.getAttribute("username"));
            model.addAttribute("usernameExist", " " + (String) session.getAttribute("username"));
            return "customer/account";
        }
    }

    /**
     * Edit any information in the form
     * @param model model map
     * @param usersEntity the user object created from the form input
     * @param session http session storage
     * @return the view
     */
    @PostMapping("/editUser")
    public String editUser(ModelMap model, UsersEntity usersEntity, HttpSession session) {
        QueryWrapper<UsersEntity> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("uname", usersEntity.getUname());
        UsersEntity old = userService.getOne(queryWrapper1);
        usersEntity.setUid(old.getUid());
        if(userService.updateById(usersEntity))
        {
            model.addAttribute("usersEntity",usersEntity);
            model.addAttribute("message","Updated!");
            model.addAttribute("loggedIn",usersEntity.getUname());
            return "customer/account";
        }
        else
        {
            model.addAttribute("message","Error updating user. Please contact developers for assistance");
            QueryWrapper<UsersEntity> queryWrapper2 = new QueryWrapper<>();
            queryWrapper2.eq("uname", session.getAttribute("username"));
            UsersEntity userLoggedIn = userService.getOne(queryWrapper2);
            model.addAttribute("usersEntity",userLoggedIn);
            model.addAttribute("loggedIn",userLoggedIn.getUname());
            model.addAttribute("usernameExist", " " +userLoggedIn.getUname());
            return "customer/account";
        }

    }

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