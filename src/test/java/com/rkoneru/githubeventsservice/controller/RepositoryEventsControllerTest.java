package com.rkoneru.githubeventsservice.controller;

import com.rkoneru.githubeventsservice.model.Event;
import com.rkoneru.githubeventsservice.service.RepositoryEventsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RepositoryEventsControllerTest {

    private static final LocalDateTime JAN_31_2020_6_15_32 = LocalDateTime.of(2020, 1, 31, 6, 15, 32);

    private ResponseEntity responseEntity;

    private RepositoryEventsController repositoryEventsController;

    @BeforeEach
    void setUp() {
        repositoryEventsController = new RepositoryEventsController(new RepositoryEventsService());
    }

    @Test
    void shouldReturnHttpResponseWith200StatusCode() {
        ResponseEntity responseEntity = repositoryEventsController.getEvents("test", "John", "ForkEvent");

        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    void shouldReturnOneEventForTestRepoWhenOwnerIsJohnAndEventTypeIsForKEvent() {
        responseEntity = repositoryEventsController.getEvents("test", "John", "ForkEvent");

        List<Event> events = (List<Event>) responseEntity.getBody();
        assertEquals(1, events.size());
    }

    @Test
    void shouldReturnCorrectEventTypeForTestRepoWhenOwnerIsJohnAndEventTypeIsForkEvent() {
        responseEntity = repositoryEventsController.getEvents("test", "John", "ForkEvent");

        List<Event> events = (List<Event>) responseEntity.getBody();
        assertEquals("ForkEvent", events.get(0).getEventType());
    }

    @Test
    void shouldReturnCorrectEventsTimeStampWhenOwnerIsJohnAndEventTypeIsForkEvent() {
        responseEntity = repositoryEventsController.getEvents("test", "John", "ForkEvent");

        List<Event> events = (List<Event>) responseEntity.getBody();
        assertEquals(JAN_31_2020_6_15_32, events.get(0).getTimestamp());
    }
}