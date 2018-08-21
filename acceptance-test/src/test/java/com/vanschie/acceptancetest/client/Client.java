package com.vanschie.acceptancetest.client;

import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.logging.Logger;

import static java.util.Arrays.asList;
import static java.util.logging.Level.WARNING;

public class Client {
    private static final Logger LOG = Logger.getLogger(Client.class.getName());

    // TODO: this nicer, the blank "" is the gateway service.
    private static final List<String> SERVICES = asList("", "authenticator/", "configuration/");

    private static final String ENDPOINT = "http://localhost:8888/";
    private static final String ACTUATOR_HEALTH = "actuator/health";

    private final RestTemplate restTemplate;

    public Client(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean allServicesAreAvalible() {

        try {
            SERVICES.forEach(service -> restTemplate.getForEntity(ENDPOINT + service + ACTUATOR_HEALTH, String.class));
        } catch (HttpStatusCodeException e) {
            LOG.log(WARNING, "Failed to get healthcheck for service", e);
            return false;
        }
        return true;
    }
}
