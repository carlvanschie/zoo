package com.vanschie.acceptancetest.step;


import com.vanschie.acceptancetest.client.Client;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class HealthCheckSteps {

    private static final Client CLIENT = new Client(new RestTemplate());

    private boolean responce;


    @When("^the client calls the health check endpoint all services$")
    public void theClientCallsTheHealthCheckEndpointAllServices() {
        responce = CLIENT.allServicesAreAvalible();
    }


    @When("^the client calls the authenticate endpoint$")
    public void theClientCallsTheAuthenticateEndpoint() {
        responce = CLIENT.authenticate("bill", "abc123");
    }

    @Then("^the client returns true$")
    public void theClientReturnsTrue() {
        assertThat(responce, is(true));
    }

}
