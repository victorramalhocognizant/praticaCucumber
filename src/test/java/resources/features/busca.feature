Feature: Google Search
    Scenario: Verify Google Search Functionality
        Given I open the Google homepage
        When I search for "Selenium"
        Then I should see search results for "Selenium"