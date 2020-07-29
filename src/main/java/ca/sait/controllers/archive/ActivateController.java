package ca.sait.controllers.archive;

import ca.sait.entity.UsersEntity;
import ca.sait.service.impl.UsersServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

@Controller
public class ActivateController {

    @Autowired
    private UsersServiceImpl usersService;

    @GetMapping(value = "/activate")
    public String activateAccount(String username, ModelMap model, String uuid) {
        if (username == null) {
            model.addAttribute("message", "Error when activate account - No account found.");

        }
        else {
            String checkuuid = UUID.randomUUID().toString();
            if(uuid==null || !uuid.equals(checkuuid)) {
                model.addAttribute("message", "Error when activate account.");
            }
            else {
                QueryWrapper<UsersEntity> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("uname", username);
                UsersEntity userLoggedIn = usersService.getOne(queryWrapper);
                userLoggedIn.setStatus("active");
                if (usersService.save(userLoggedIn)) {
                    model.addAttribute("message", "Account activated, you can log in with your new account.");
                }
                else {
                    model.addAttribute("message", "Error when saving account information.");
                }
            }
        }
        model.addAttribute("usersEntity", new UsersEntity());
        return "customer/login";
    }
}
//        try {
//            String username = request.getParameter("inputUsername");
//                //us =new  UserService();
//            QueryWrapper<UsersEntity> queryWrapper = new QueryWrapper<>();
//            queryWrapper.eq("uname", username);
//            UsersEntity user = us.getOne(queryWrapper);
//                //ArrayList<UsersEntity> allUsers = (ArrayList<UsersEntity>) us.list();
//                if(validation(email,allUsers))
//                {
//            //HttpSession session = request.getSession();
//            //us.insert(username, password, fname, lname,email);
//            //response.getWriter().write("Successful!");
//            ArrayList<UsersEntity> users = (ArrayList<UsersEntity>) us.(email);
//            String subject = "Get Username";
//            String template = "src\\main\\resources\\templates\\emailtemplate\\recoveryemail.html" ;
//            HashMap<String, String> tags = new HashMap<>();
////            tags.put("firstname", users.get(0).getFirstName());
////            tags.put("lastname", users.get(0).getLastName());
////            tags.put("username", users.get(0).getUserName());
//            tags.put("link", as.getLink(request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/newUsername?action=newuser"));
//            GmailService.sendMail1(email, subject, template, tags);
//            //session.setAttribute("unactivatedUser",username);
//            //request.setAttribute("errorMessage", "Done! Check your mailbox for account activation");
//            //getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
//                    return "report";
//                }
//                else
//                {
//                    return "redirect:/invalidEmail";
//                }
//
////                HashMap<String, String> tags = new HashMap();
////                tags.put("email",email);
////                File file = new File("/templates/report.html");
////                BufferedReader br = new BufferedReader(new FileReader(file));
////                String line = br.readLine();
////                String body = "";
////                while(line != null) {
////                    body += line;
////                    line = br.readLine();
////                }
////
////                // replace all heart tags with values
////                for(String tag : tags.keySet()) {
////                    body = body.replace("%" + tag + "%", tags.get(tag));
////
////                }
//        }catch (Exception e)
//        {
//            return "recovery";
//        }
//
//    }
//
//    private boolean validation(String email, ArrayList<UsersEntity> allUsers) {
//        boolean isFound= false;
//        for (UsersEntity user: allUsers)
//        {
//            if(email.equals(user.getEmail()))
//            {
//                isFound=true;
//                break;
//            }
//        }
//
//        return isFound;
//    }

