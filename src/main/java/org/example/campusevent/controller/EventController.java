// Name: Brendon ID: 761008604

package org.example.campusevent.controller;

import org.example.campusevent.model.Event;
import org.example.campusevent.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return service.getAllEvents();
    }

    @GetMapping("/{id}")
    public Event getEvent(@PathVariable Long id) {
        return service.getEventById(id).orElse(null);
    }

    @GetMapping("/search")
    public List<Event> searchEvents(@RequestParam String name) {
        return service.searchEventsByName(name);
    }

    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return service.createEvent(event);
    }

    @PutMapping("/{id}")
    public int updateLocation(@PathVariable Long id,
                              @RequestParam String location) {
        return service.updateEventLocation(id, location);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        service.deleteEvent(id);
    }
}