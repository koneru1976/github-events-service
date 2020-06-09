package com.rkoneru.githubeventsservice.model;

public class Event {
    private final String eventType;

    public Event(String eventType) {
        this.eventType = eventType;
    }

    public String getEventType() {
        return eventType;
    }
}
