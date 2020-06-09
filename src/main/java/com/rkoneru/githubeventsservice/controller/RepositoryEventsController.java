package com.rkoneru.githubeventsservice.controller;

import com.rkoneru.githubeventsservice.model.Event;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RequestMapping("/repositories/{repository}/events")
@RestController
public class RepositoryEventsController {

    @GetMapping
    public ResponseEntity getEvents(@PathVariable("repository") String repository,
                                    @RequestParam("owner") String owner,
                                    @RequestParam("event-type") String eventType) {
        return ResponseEntity.ok(Arrays.asList(new Event(eventType)));
    }
}
