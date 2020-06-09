package com.rkoneru.githubeventsservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/repos/events")
@RestController
public class EventsController {

    @GetMapping
    public ResponseEntity getEvents() {
        return ResponseEntity.ok(null);
    }
}
