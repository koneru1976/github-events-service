package com.rkoneru.githubeventsservice.integration;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.time.LocalDateTime;

public class GithubRepositoryEvent {
    @JsonAlias("type")
    private final String eventType;

    @JsonAlias("actor")
    private final GithubRepositoryEventActor actor;

    @JsonAlias("created_at")
    private final LocalDateTime timestamp;

    public GithubRepositoryEvent(String eventType, GithubRepositoryEventActor actor, LocalDateTime timestamp) {
        this.eventType = eventType;
        this.actor = actor;
        this.timestamp = timestamp;
    }

    public String getEventType() {
        return eventType;
    }


    public GithubRepositoryEventActor getActor() {
        return actor;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
