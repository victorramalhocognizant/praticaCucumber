package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GoogleHomePage;

public class GoogleLoginSteps {
    
    @When("I Login with username {string} and password {string}")
    public void loginGoogle(String username, String password){
        
    }

    @Then("I should see the logged page")
    public void verifyLogin(){
        
    }
    
}
