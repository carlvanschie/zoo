Feature: the health check can be received

  Scenario: Authenticator healthcheck can be received
    When the client calls the health check endpoint all services
    Then the client returns true
