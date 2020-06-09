package com.rkoneru.githubservice.service;

import com.rkoneru.githubeventsservice.model.Event;
import com.rkoneru.githubeventsservice.service.RepositoryEventsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RepositoryEventsServiceTest {

    private RepositoryEventsService repositoryEventsService;

    @BeforeEach
    void setUp() {
        repositoryEventsService = new RepositoryEventsService();
    }

    @Test
    void shouldReturnOneEvent() {
        List<Event> events = repositoryEventsService.getEvents("test", "john", "ForkEvent");

        assertEquals(1, events.size());
    }
}