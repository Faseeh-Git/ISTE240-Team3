package org.example.campusevent.controller;

import org.example.campusevent.model.Event;
import org.example.campusevent.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService){
        this.eventService = eventService;
    }

    @GetMapping("/event")
    public String getEvents(Model model){
        model.addAttribute("events", eventService.getEvents());
        return "event";
    }

    @GetMapping("/event/add")
    public String showAddEvent(){
        return "addevent";
    }

    @PostMapping("/event/add")
    public String addEvent(Event event){
        eventService.addEvent(event);
        return "success";
    }
}
