package com.example2.controllers.archive;

import com.example2.entity.UserEntity;
import com.example2.service.AccountService;
import com.example2.service.GmailService;
import com.example2.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class RecoverController {

    @RequestMapping(value = "/recovery", method= RequestMethod.POST)
    public String sendMail(HttpServletRequest request, HttpServletResponse response) {
        try {
            String email = request.getParameter("inputUsername");
                UserService us =new  UserService();
                AccountService as = new AccountService();
//                ArrayList<UserEntity> allUsers = (ArrayList<UserEntity>) us.getAllUsers();
//                if(validation(email,allUsers))
//                {
            //HttpSession session = request.getSession();
            //us.insert(username, password, fname, lname,email);
            //response.getWriter().write("Successful!");
            String subject = "Get Username";
            String template = "src\\main\\resources\\templates\\emailtemplate\\recoveryemail.html" ;
            HashMap<String, String> tags = new HashMap<>();
            //tags.put("firstname", fname);
            //tags.put("lastname", lname);
            //tags.put("username", username);
            tags.put("link", as.getLink(request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/newUsername?action=newuser"));
            GmailService.sendMail1(email, subject, template, tags);
            //session.setAttribute("unactivatedUser",username);
            //request.setAttribute("errorMessage", "Done! Check your mailbox for account activation");
            //getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                    return "report";
//                }
//                else
//                {
//                    return "redirect:/invalidEmail";
//                }

//                HashMap<String, String> tags = new HashMap();
//                tags.put("email",email);
//                File file = new File("/templates/report.html");
//                BufferedReader br = new BufferedReader(new FileReader(file));
//                String line = br.readLine();
//                String body = "";
//                while(line != null) {
//                    body += line;
//                    line = br.readLine();
//                }
//
//                // replace all heart tags with values
//                for(String tag : tags.keySet()) {
//                    body = body.replace("%" + tag + "%", tags.get(tag));
//
//                }
        }catch (Exception e)
        {
            return "recovery";
        }

    }

    private boolean validation(String email, ArrayList<UserEntity> allUsers) {
        boolean isFound= false;
        for (UserEntity user: allUsers)
        {
            if(email.equals(user.getEmail()))
            {
                isFound=true;
                break;
            }
        }

        return isFound;
    }
}
