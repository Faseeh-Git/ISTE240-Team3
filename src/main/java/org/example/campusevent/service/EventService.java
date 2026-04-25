// Name: Brendon ID: 761008604

package org.example.campusevent.service;

import jakarta.transaction.Transactional;
import org.example.campusevent.model.Event;
import org.example.campusevent.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EventService {

    private final EventRepository repository;

    public EventService(EventRepository repository) {
        this.repository = repository;
    }

    public Event createEvent(Event event) {
        return repository.save(event);
    }

    public List<Event> getAllEvents() {
        return repository.findAll();
    }

    public Optional<Event> getEventById(Long id) {
        return repository.findById(id);
    }

    public List<Event> searchEventsByName(String name) {
        return repository.findByEventName(name);
    }

    public int updateEventLocation(Long id, String location) {
        return repository.updateLocationById(id, location);
    }

    public void deleteEvent(Long id) {
        repository.deleteById(id);
    }
}