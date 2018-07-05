package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import models.Environment;
import utilities.Helper;

public class BaseSteps {

    AppiumDriver driver;

    public BaseSteps(){
        this.driver = Environment.driver;
    }

    @Given("^I open HCNV app$")
    public void open_hcvn_app() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Helper.log(Environment.server.getURL().toString());
    }

    @When("^Wait for (\\d+) seconds$")
    public void waitForSeconds(int seconds) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        this.driver.wait(seconds);
    }
}
