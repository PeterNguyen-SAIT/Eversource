package ca.sait.controllers;

import ca.sait.entity.EventsEntity;
import ca.sait.entity.ProductsEntity;
import ca.sait.entity.UsersEntity;
import ca.sait.service.impl.EventsServiceImpl;
import ca.sait.service.impl.ProductsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class EventController {
    @Autowired
    private EventsServiceImpl eventsService;

    @GetMapping("/event")
    public String showEventPage(ModelMap model, HttpSession session) {

            List<EventsEntity> eventsEntityList = eventsService.list();
            String username = (String) session.getAttribute("username");
            model.addAttribute("loggedIn", " " + username);
            model.addAttribute("usernameExist", username);
            model.addAttribute("eventsEntityList", eventsEntityList);
            return "customer/event";

    }

    @PostMapping("/eventNotice")
    public String registerEvent(Model model, HttpSession session, EventsEntity event, String ids) {
        String username = (String)session.getAttribute("username");
        if(username==null || username.equals(""))
        {
            model.addAttribute("message","Please login first");
            model.addAttribute("usersEntity", new UsersEntity());
            return "customer/login";
        }
        else
        {
//            System.out.println(new Date());
//            if(event.getStart().compareTo(new Date())==0)
//            {
//                model.addAttribute("message", "Event is currently ongoing.");
//            }
//            else
//                if(event.getStart().compareTo(new Date())>0)
//                {
//                    model.addAttribute("message", "Event has ended.");
//                }
//            else {
//                model.addAttribute("message", "Reminder activated.");
//
//            }
            model.addAttribute("message", "Reminder activated.");
            List<EventsEntity> eventsEntityList = eventsService.list();
            model.addAttribute("loggedIn", " " + username);
            model.addAttribute("usernameExist", username);
            model.addAttribute("eventsEntityList", eventsEntityList);
            return "customer/event";
        }

    }
}
