Feature: a user is able to authenticate

  Scenario: Authenticator is able to gra
    When the client calls the authenticate endpoint
    Then the client returns true
