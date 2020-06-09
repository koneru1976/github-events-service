package com.rkoneru.githubeventsservice.controller;

import com.rkoneru.githubeventsservice.model.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RepositoryEventsControllerTest {

    private RepositoryEventsController repositoryEventsController;

    @BeforeEach
    void setUp() {
        repositoryEventsController = new RepositoryEventsController();
    }

    @Test
    void shouldReturnHttpResponseWith200StatusCode() {
        ResponseEntity responseEntity = repositoryEventsController.getEvents("test", "John", "ForkEvent");

        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    void shouldReturnOneEventForTestRepoWhenOwnerIsJohnAndEventTypeIsForKEvent() {
        ResponseEntity responseEntity = repositoryEventsController.getEvents("test", "John", "ForkEvent");

        List<Event> events = (List<Event>) responseEntity.getBody();
        assertEquals(1, events.size());
    }
}