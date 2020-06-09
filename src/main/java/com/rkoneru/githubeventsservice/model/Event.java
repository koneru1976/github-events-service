package com.rkoneru.githubeventsservice.model;

import java.time.LocalDateTime;

public class Event {
    private final String eventType;
    private final LocalDateTime timestamp;

    public Event(String eventType, LocalDateTime timestamp) {
        this.eventType = eventType;
        this.timestamp = timestamp;
    }

    public String getEventType() {
        return eventType;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
