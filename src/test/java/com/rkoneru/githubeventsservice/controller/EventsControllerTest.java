package com.rkoneru.githubeventsservice.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EventsControllerTest {

    private EventsController eventsController;

    @BeforeEach
    void setUp() {
        eventsController = new EventsController();
    }

    @Test
    void shouldReturnHttpResponseWith200StatusCode() {
        ResponseEntity responseEntity = eventsController.getEvents();

        assertEquals(200, responseEntity.getStatusCodeValue());
    }
}