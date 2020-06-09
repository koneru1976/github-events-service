package com.rkoneru.githubservice;

import com.rkoneru.githubeventsservice.GithubEventsServiceApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = GithubEventsServiceApplication.class)
public class GithubEventsServiceIT {

    @Test
    void shouldStartApplication() {
        assertTrue(true);
    }
}
