package ca.sait.controllers;

import ca.sait.entity.UsersEntity;
import ca.sait.service.GmailService;
import ca.sait.service.impl.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * Lost controller class handles losing username/password
 */
@Controller
public class LostController {

    @Autowired
    UsersServiceImpl usersService;

    /**
     * Call appropriate view based on the value received
     * @param value the value received
     * @return the view
     */
    @RequestMapping("/retrieve")
    public String recover(String value)
    {
        if(value.equals("username"))
        {
            return "customer/forgetUsername";
        }
        else
            if(value.equals("password"))
        {
            return "customer/forgetPassword";
        }
            return "test/errorPage_404";
    }

    /**
     * Handle losing username, send the gmail's owner the username
     * @param session session storage
     * @param email email received from user
     * @param model model map
     * @return the view
     */
    @RequestMapping("/lostUsername")
    public String recoverUname(HttpSession session, String email, ModelMap model) {
            String username=null;

            List<UsersEntity> allUsers = usersService.list();
            boolean isFound = false;

            for (UsersEntity user : allUsers) {
                if (user.getEmail().equals(email)) {
                    isFound = true;
                    username = user.getUname();

                }
            }
            if (!isFound) {
                model.addAttribute("message", "Email not registered.");
                model.addAttribute("usernameExist",username);
                model.addAttribute("loggedIn",username);
                return "customer/forgetUsername";
            } else {

                String subject = "Forget Username";
                String template = "src\\main\\resources\\templates\\customer\\forgotUnameorPass.html";
                HashMap<String, String> tags = new HashMap<>();
                tags.put("username", "");
                tags.put("infoName", "Username");
                tags.put("infoVal", username);

                GmailService.sendMail1(email, subject, template, tags);
                model.addAttribute("message","Verification email sent.");
            }
            model.addAttribute("usersEntity", new UsersEntity());
        model.addAttribute("usernameExist",username);
        model.addAttribute("loggedIn",username);
        return "customer/login";
    }

    /**
     * Handle losing password, send the gmail's owner the password
     * @param session storage
     * @param email email received from user
     * @param model model map
     * @return the view
     */
    @RequestMapping("/lostPassword")
    public String recoverPass(HttpSession session, String email, ModelMap model) {
            String password=null;
            String username=null;

            List<UsersEntity> allUsers = usersService.list();
            boolean isFound = false;
            for (UsersEntity user : allUsers) {
                if (user.getEmail().equals(email)) {
                    isFound = true;
                    password = user.getPassword();
                    username = user.getUname();

                }
            }
            if (!isFound) {
                model.addAttribute("message", "Email not registered.");
                model.addAttribute("usernameExist",username);
                model.addAttribute("loggedIn",username);
                return "customer/forgetPassword";
            } else {

                String subject = "Forget Password";
                String template = "src\\main\\resources\\templates\\customer\\forgotUnameorPass.html";
                HashMap<String, String> tags = new HashMap<>();
                tags.put("username", "");
                tags.put("infoName", "Password");
                tags.put("infoVal", password);

                GmailService.sendMail1(email, subject, template, tags);
                model.addAttribute("message","Verification email sent.");
            }

            model.addAttribute("usersEntity", new UsersEntity());
            model.addAttribute("usernameExist",username);
            model.addAttribute("loggedIn",username);
        return "customer/login";
    }


//    @RequestMapping("/invalidEmail")
//    public String printError(ModelMap model) {
//        model.addAttribute("message","Invalid email address");
//        return "recovery";
//    }

}

