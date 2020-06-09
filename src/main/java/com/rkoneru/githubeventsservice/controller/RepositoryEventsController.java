package com.rkoneru.githubeventsservice.controller;

import com.rkoneru.githubeventsservice.service.RepositoryEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/repositories/{repository}/events")
@RestController
public class RepositoryEventsController {

    private final RepositoryEventsService repositoryEventsService;

    @Autowired
    public RepositoryEventsController(RepositoryEventsService repositoryEventsService) {
        this.repositoryEventsService = repositoryEventsService;
    }

    @GetMapping
    public ResponseEntity getEvents(@PathVariable("repository") String repository,
                                    @RequestParam("owner") String owner,
                                    @RequestParam("event-type") String eventType) {
        return ResponseEntity.ok(repositoryEventsService.getEvents(repository, owner, eventType));
    }
}
