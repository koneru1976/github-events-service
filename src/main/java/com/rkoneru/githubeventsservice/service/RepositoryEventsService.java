package com.rkoneru.githubeventsservice.service;

import com.rkoneru.githubeventsservice.model.Event;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class RepositoryEventsService {

    public List<Event> getEvents(String repository, String owner, String eventType) {
        return Arrays.asList(new Event(eventType, LocalDateTime.of(2020, 1, 31, 6, 15, 32)));
    }
}
