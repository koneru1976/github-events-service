package com.rkoneru.githubeventsservice.integration;

import java.time.LocalDateTime;

public class GithubRepositoryEvent {
    private final String eventType;
    private final LocalDateTime timestamp;

    public GithubRepositoryEvent(String eventType, LocalDateTime timestamp) {
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
