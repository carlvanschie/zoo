package com.vanschie.acceptancetest.step;


import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class HealthCheckSteps {

    private final RestTemplate restTemplate = new RestTemplate();

    private ResponseEntity<String> entity;

    @When("^the client calls the health check endpoint$")
    public void theClientCallsTheHealthCheckEndpoint() {
        entity = restTemplate.getForEntity("http://localhost:8888/actuator/health", String.class);
    }

    @Then("^the client receives status code of (\\d+)$")
    public void theClientReceivesStatusCodeOf(int statusCode) {
        assertThat(entity.getStatusCode().value(), is(statusCode));
    }
}
