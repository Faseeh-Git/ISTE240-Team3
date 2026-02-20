package org.example.campusevent.model;

import org.springframework.stereotype.Component;

@Component
public class Event {
    private int eventID;
    private String eventName;
    private String eventDescription;
    private String eventLocation;
    private String date;
    private String hostName;

    public Event() {

    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    @Override
    public String toString() {
        return "Event [eventID=" + eventID +
                ", eventName=" + eventName +
                ", eventDescription=" + eventDescription +
                ", eventLocation=" + eventLocation +
                ", date=" + date +
                ", hostName=" + hostName + "]";
    }

}
