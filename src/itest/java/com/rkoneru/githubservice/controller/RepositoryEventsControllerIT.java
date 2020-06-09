package com.rkoneru.githubservice.controller;

import com.rkoneru.githubeventsservice.GithubEventsServiceApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@AutoConfigureMockMvc
@SpringBootTest(classes = GithubEventsServiceApplication.class)
public class RepositoryEventsControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnHttpResponseWith200StatusCode() throws Exception {
        RequestBuilder rb = MockMvcRequestBuilders.get("/repositories/test/events?owner=John&event-type=ForkEvent");

        MvcResult mvcResult = mockMvc.perform(rb).andReturn();

        assertEquals(200, mvcResult.getResponse().getStatus());
    }
}
