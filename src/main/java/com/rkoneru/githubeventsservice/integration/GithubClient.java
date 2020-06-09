package com.rkoneru.githubeventsservice.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "githubClient", url = "${github.api.url}")
public interface GithubClient {

    @GetMapping("/repos/{owner}/{repo}/events")
    List<GithubRepositoryEvent> getRepositoryEventsByOwnerAndRepo(@PathVariable("owner") String owner,
                                                                  @PathVariable("repo") String repo);
}
