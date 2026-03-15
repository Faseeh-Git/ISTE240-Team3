package org.example.campusevent.service;


import org.example.campusevent.model.Event;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    private List<Event> events = new ArrayList<>();

    public EventService(){
        events.add(new Event(1, "Hackathon", "Bringing great minds together", "RIT DUBAI", "01, 06, 2026", "John"));
        events.add(new Event(2, "Spring fest", "Sports day", "RIT DUBAI","20, 05, 2026", "James"));
    }

    public List<Event> getEvents(){
        return events;
    }

    public void addEvent(Event event){
        events.add(event);
    }
}
