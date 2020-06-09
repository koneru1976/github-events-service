package com.rkoneru.githubeventsservice.model;

import java.time.LocalDateTime;

public class Event {
    private final String eventType;
    private final Actor actor;
    private final LocalDateTime timestamp;

    public Event(String eventType, Actor actor, LocalDateTime timestamp) {
        this.eventType = eventType;
        this.actor = actor;
        this.timestamp = timestamp;
    }

    public String getEventType() {
        return eventType;
    }

    public Actor getActor() {
        return actor;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
