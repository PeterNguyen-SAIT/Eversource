package ca.sait.controllers.archive;

import org.springframework.stereotype.Controller;

@Controller
public class RecoverController {
//    @Autowired
//    private UsersServiceImpl us;
//
//    @RequestMapping(value = "/recovery", method= RequestMethod.POST)
//    public String sendMail(HttpServletRequest request, HttpServletResponse response) {
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
}
