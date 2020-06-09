package com.rkoneru.githubeventsservice.service;

import com.rkoneru.githubeventsservice.integration.GithubClient;
import com.rkoneru.githubeventsservice.integration.GithubRepositoryEvent;
import com.rkoneru.githubeventsservice.integration.GithubRepositoryEventActor;
import com.rkoneru.githubeventsservice.model.Actor;
import com.rkoneru.githubeventsservice.model.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RepositoryEventsService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final GithubClient githubClient;

    @Autowired
    public RepositoryEventsService(GithubClient githubClient) {
        this.githubClient = githubClient;
    }

    public List<Event> getEvents(String repository, String owner, String eventType) {
        List<GithubRepositoryEvent> githubRepositoryEvents = githubClient.getRepositoryEventsByOwnerAndRepo(owner, repository);
        logger.info("Events retrieved for repo {} and owner {}, event type {}: {}", repository, owner, eventType, githubRepositoryEvents);

        return githubRepositoryEvents.stream().filter(e -> e.getEventType().equalsIgnoreCase(eventType))
                .map(e -> {
                    GithubRepositoryEventActor githubRepositoryEventActor = e.getActor();
                    Actor actor = new Actor(githubRepositoryEventActor.getId(), githubRepositoryEventActor.getLogin(), githubRepositoryEventActor.getDisplayLogin(), githubRepositoryEventActor.getGravatarId(), githubRepositoryEventActor.getUrl(), githubRepositoryEventActor.getAvatarUrl());
                    return new Event(e.getEventType(), actor, e.getTimestamp());
                })
                .collect(Collectors.toList());
    }
}
