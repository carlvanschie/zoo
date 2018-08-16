Feature: the health check can be received
  Scenario: healthcheck can be received
    When the client calls the health check endpoint
    Then the client receives status code of 200