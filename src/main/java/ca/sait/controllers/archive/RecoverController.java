package ca.sait.controllers.archive;

import ca.sait.service.AccountService;
import ca.sait.service.GmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class RecoverController {
    @Autowired
    private UserService us;

    @RequestMapping(value = "/recovery", method= RequestMethod.POST)
    public String sendMail(HttpServletRequest request, HttpServletResponse response) {
        try {
            String email = request.getParameter("inputUsername");
                //us =new  UserService();
                AccountService as = new AccountService();
                ArrayList<UserEntity> allUsers = (ArrayList<UserEntity>) us.getAllUsers();
                if(validation(email,allUsers))
                {
            //HttpSession session = request.getSession();
            //us.insert(username, password, fname, lname,email);
            //response.getWriter().write("Successful!");
            ArrayList<UserEntity> users = (ArrayList<UserEntity>) us.getUsersByEmail(email);
            String subject = "Get Username";
            String template = "src\\main\\resources\\templates\\emailtemplate\\recoveryemail.html" ;
            HashMap<String, String> tags = new HashMap<>();
            tags.put("firstname", users.get(0).getFirstName());
            tags.put("lastname", users.get(0).getLastName());
            tags.put("username", users.get(0).getUserName());
            tags.put("link", as.getLink(request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/newUsername?action=newuser"));
            GmailService.sendMail1(email, subject, template, tags);
            //session.setAttribute("unactivatedUser",username);
            //request.setAttribute("errorMessage", "Done! Check your mailbox for account activation");
            //getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                    return "report";
                }
                else
                {
                    return "redirect:/invalidEmail";
                }

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
