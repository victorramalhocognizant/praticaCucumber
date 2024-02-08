Feature: Login google
    Scenario: Correct Login
        Given I open the Google homepage
        When I Login with username "teste" and password "teste"
        Then I should see the logged page

    Scenario: Incorrect Login
        Given I open the Google homepage
        When I Login with username "teste" and password "errada"
        Then I should see the logged page

        