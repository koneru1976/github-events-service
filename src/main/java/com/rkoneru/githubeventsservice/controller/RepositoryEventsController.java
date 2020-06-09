package com.rkoneru.githubeventsservice.controller;

import com.rkoneru.githubeventsservice.model.Event;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;

@RequestMapping("/repositories/{repository}/events")
@RestController
public class RepositoryEventsController {

    @GetMapping
    public ResponseEntity getEvents(@PathVariable("repository") String repository,
                                    @RequestParam("owner") String owner,
                                    @RequestParam("event-type") String eventType) {
        return ResponseEntity.ok(Arrays.asList(new Event(eventType, LocalDateTime.of(2020, 1, 31, 6, 15, 32))));
    }
}
