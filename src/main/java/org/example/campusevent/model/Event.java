// Name: Brendon ID: 761008604

package org.example.campusevent.model;

import jakarta.persistence.*;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventID;

    @Column(length = 50, nullable = false)
    private String eventName;

    @Column(nullable = false)
    private String eventDescription;

    @Column(nullable = false)
    private String eventLocation;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private String hostName;

    public Event(){}

    public Event(String eventName,
                 String eventDescription,
                 String eventLocation,
                 String date,
                 String hostName) {

        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventLocation = eventLocation;
        this.date = date;
        this.hostName = hostName;
    }

    public Long getEventID() {
        return eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public String getDate() {
        return date;
    }

    public String getHostName() {
        return hostName;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }
}