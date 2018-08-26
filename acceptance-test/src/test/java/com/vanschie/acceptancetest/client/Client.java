package com.vanschie.acceptancetest.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.vanschie.acceptancetest.client.model.OAuthToken;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.List;
import java.util.logging.Logger;

import static java.util.Arrays.asList;
import static java.util.logging.Level.WARNING;

public class Client {
    private static final Logger LOG = Logger.getLogger(Client.class.getName());

    // TODO: this nicer, the blank "" is the gateway service.
    private static final List<String> SERVICES = asList("", "authenticator/", "configuration/");

    private static final String ENDPOINT = "http://localhost:8888";
    private static final String ACTUATOR_HEALTH = "/actuator/health";

    private final RestTemplate restTemplate;

    private OAuthToken oAuthToken;

    public Client(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    private static final String authenticateUrl = "http://localhost:8888/authenticator/oauth/token?grant_type=password&username=bill&password=abc123";


    private HttpHeaders createHeaders(String username, String password){
        return new HttpHeaders() {{
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")) );
            String authHeader = "Basic " + new String( encodedAuth );
            set( "Authorization", authHeader );
        }};
}

    public boolean authenticate(String userName, String password) {
        String url = ENDPOINT + "/authenticator/oauth/token?grant_type=password&username="+ userName +"&password=" + password;

        try {
            ResponseEntity<JsonNode> responseEntity = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity(createHeaders("my-trusted-client","secret")), JsonNode.class);

            JsonNode responseNode = responseEntity.getBody();
            String accessType = responseNode.get("access_token").asText();
            String tokenType = responseNode.get("token_type").asText();
            String refreshToken = responseNode.get("refresh_token").asText();
            String scope = responseNode.get("scope").asText();
            int expiresIn = responseNode.get("expires_in").asInt();

            oAuthToken = new OAuthToken(accessType, tokenType, refreshToken, scope, expiresIn);
            System.out.println(oAuthToken);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
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
