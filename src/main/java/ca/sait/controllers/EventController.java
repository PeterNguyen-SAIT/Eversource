package ca.sait.controllers;

import ca.sait.entity.EventsEntity;
import ca.sait.entity.ProductsEntity;
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
import java.util.List;

@Controller
public class EventController {
    @Autowired
    private EventsServiceImpl eventsService;

    @GetMapping("/event")
    public String showEventPage(ModelMap model, HttpSession session) {
        List<EventsEntity> eventsEntityList = eventsService.list();
        if(session.getAttribute("username") == null)
        {

        }
        else
            {

            model.addAttribute("loggedIn", session.getAttribute("username"));
        }
        model.addAttribute("username", session.getAttribute("username"));
        model.addAttribute("eventsEntityList", eventsEntityList);
        return "customer/event";
    }

    @PostMapping("/event")
    public String registerEvent(Model model) {

        return "customer/event";
    }
}
