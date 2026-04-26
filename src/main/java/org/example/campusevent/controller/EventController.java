// Name: Brendon ID: 761008604

package org.example.campusevent.controller;

import org.example.campusevent.model.Event;
import org.example.campusevent.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    // List all events
    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    // Search events
    @GetMapping("/search")
    public List<Event> searchEvents(@RequestParam String name) {
        return eventService.findByEventName(name);
    }

    // Save event
    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventService.save(event);
    }

    // Update event
    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable Long id,
                             @RequestBody Event event) {
        return eventService.update(id, event);
    }
}