// Name: Brendon ID: 761008604

package org.example.campusevent.service;

import org.example.campusevent.model.Event;
import org.example.campusevent.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    // Get all events
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // Search events by name
    public List<Event> findByEventName(String name) {
        return eventRepository.findByEventName(name);
    }

    // Save event
    public Event save(Event event) {
        return eventRepository.save(event);
    }

    // Update event
    public Event update(Long id, Event updatedEvent) {

        Event existing = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        existing.setEventName(updatedEvent.getEventName());
        existing.setEventDescription(updatedEvent.getEventDescription());
        existing.setEventLocation(updatedEvent.getEventLocation());
        existing.setDate(updatedEvent.getDate());
        existing.setHostName(updatedEvent.getHostName());

        return eventRepository.save(existing);
    }

}