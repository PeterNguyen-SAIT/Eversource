package com.example2.controllers.archive;

import com.example2.entity.UserEntity;
import com.example2.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@Controller
public class RecoverController {

    @RequestMapping(value = "/recovery", method= RequestMethod.POST)
    public String sendMail(HttpServletRequest request, HttpServletResponse response) {
        try {
            String email = request.getParameter("inputUsername");

            if (email == null || email.equals("")) {
                //request.setAttribute("message", "Invalid email address");
                //response.sendRedirect("recovery");

                //request.getRequestDispatcher("/templates/recovery.html").forward(request,response);
                return "recovery";
            } else {
                UserService us =new  UserService();
                //ArrayList<UserEntity> allUsers = (ArrayList<UserEntity>) us.getAllUsers();
//                if(validation(email,allUsers))
//                {
//                    return "report";
//                }
//                else
//                {
                    return "redirect:/invalidEmail";
                //}

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

            }

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
