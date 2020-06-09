package com.rkoneru.githubeventsservice.service;

import com.rkoneru.githubeventsservice.integration.FakeGithubClient;
import com.rkoneru.githubeventsservice.model.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.rkoneru.githubeventsservice.integration.FakeGithubClient.JAN_31_2020_06_15_32;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RepositoryEventsServiceTest {

    private RepositoryEventsService repositoryEventsService;

    @BeforeEach
    void setUp() {
        repositoryEventsService = new RepositoryEventsService(new FakeGithubClient());
    }

    @Test
    void shouldReturnZeroEventsForTest1RepoWhenOwnerIsJohnAndEventTypeIsForkEvent() {
        List<Event> events = repositoryEventsService.getEvents("test1", "john", "ForkEvent");

        assertEquals(0, events.size());
    }

    @Test
    void shouldReturnZeroEventsForTestRepoWhenOwnerIsJohnAndEventTypeIsWatchEvent() {
        List<Event> events = repositoryEventsService.getEvents("test", "john", "WatchEvent");

        assertEquals(0, events.size());
    }

    @Test
    void shouldReturnZeroEventsForTestRepoWhenOwnerIsJohnAndEventTypeIsForkEvent() {
        List<Event> events = repositoryEventsService.getEvents("test", "Joe", "ForkEvent");

        assertEquals(0, events.size());
    }

    @Test
    void shouldReturnOneEventForTestRepoWhenOwnerIsJohnAndEventTypeIsForkEvent() {
        List<Event> events = repositoryEventsService.getEvents("test", "john", "ForkEvent");

        assertEquals(1, events.size());
    }

    @Test
    void shouldReturnCorrectEventType() {
        List<Event> events = repositoryEventsService.getEvents("test", "john", "ForkEvent");

        assertEquals("ForkEvent", events.get(0).getEventType());
    }

    @Test
    void shouldReturnCorrectTimeStamp() {
        List<Event> events = repositoryEventsService.getEvents("test", "john", "ForkEvent");

        assertEquals(JAN_31_2020_06_15_32, events.get(0).getTimestamp());
    }

    @Test
    void shouldReturnActorsId() {
        List<Event> events = repositoryEventsService.getEvents("test", "john", "ForkEvent");

        assertEquals(123L, events.get(0).getActor().getId());
    }

    @Test
    void shouldReturnActorsLogin() {
        List<Event> events = repositoryEventsService.getEvents("test", "john", "ForkEvent");

        assertEquals("johngit", events.get(0).getActor().getLogin());
    }

    @Test
    void shouldReturnActorsDisplayLogin() {
        List<Event> events = repositoryEventsService.getEvents("test", "john", "ForkEvent");

        assertEquals("dlogin", events.get(0).getActor().getDisplayLogin());
    }

    @Test
    void shouldReturnActorsGravatarId() {
        List<Event> events = repositoryEventsService.getEvents("test", "john", "ForkEvent");

        assertEquals("gravid", events.get(0).getActor().getGravatarId());
    }

    @Test
    void shouldReturnActorsUrl() {
        List<Event> events = repositoryEventsService.getEvents("test", "john", "ForkEvent");

        assertEquals("url", events.get(0).getActor().getUrl());
    }
    @Test
    void shouldReturnActorsAvatarUrl() {
        List<Event> events = repositoryEventsService.getEvents("test", "john", "ForkEvent");

        assertEquals("avatarUrl", events.get(0).getActor().getAvatarUrl());
    }
}