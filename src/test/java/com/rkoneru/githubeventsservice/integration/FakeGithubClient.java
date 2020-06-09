package com.rkoneru.githubeventsservice.integration;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class FakeGithubClient implements GithubClient {

    public static final LocalDateTime JAN_31_2020_06_15_32 = LocalDateTime.of(2020, 1, 31, 6, 15, 32);

    @Override
    public List<GithubRepositoryEvent> getRepositoryEventsByOwnerAndRepo(String owner, String repo) {
        if ("john".equalsIgnoreCase(owner) && "test".equalsIgnoreCase(repo)) {
            return Arrays.asList(new GithubRepositoryEvent("ForkEvent", JAN_31_2020_06_15_32));
        }
        return null;
    }
}