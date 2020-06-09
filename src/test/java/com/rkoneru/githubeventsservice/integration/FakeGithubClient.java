package com.rkoneru.githubeventsservice.integration;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FakeGithubClient implements GithubClient {

    public static final LocalDateTime JAN_31_2020_06_15_32 = LocalDateTime.of(2020, 1, 31, 6, 15, 32);

    @Override
    public List<GithubRepositoryEvent> getRepositoryEventsByOwnerAndRepo(String owner, String repo) {
        if ("john".equalsIgnoreCase(owner) && "test".equalsIgnoreCase(repo)) {
            GithubRepositoryEventActor actor = new GithubRepositoryEventActor(123L, "johngit", "dlogin", "gravid", "url", "avatarUrl");
            return Arrays.asList(new GithubRepositoryEvent("ForkEvent", actor, JAN_31_2020_06_15_32));
        }
        return Collections.emptyList();
    }
}