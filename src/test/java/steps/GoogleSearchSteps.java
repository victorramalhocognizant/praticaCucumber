package steps;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GoogleHomePage;

public class GoogleSearchSteps {

    private GoogleHomePage googleHomePage;

    @Given("I open the Google homepage")
    public void openGoogleHomePage(){
        googleHomePage = new GoogleHomePage(Hooks.getDriver());
        googleHomePage.open();
        Hooks.captureScreenshot("pass", "I open the Google homepage");
    }
    
    @When("I search for {string}")
    public void searchKeyword(String keyword){
        googleHomePage.search(keyword);
        Hooks.captureScreenshot("pass", "I search for "+keyword);
    }

    @Then("I should see search results for {string}")
    public void verifySearchResults(String keyword) {
       Assert.assertTrue(googleHomePage.getTitle().contains(keyword));
       Hooks.captureScreenshot("pass", "I should see search results for "+keyword);
    }
}
