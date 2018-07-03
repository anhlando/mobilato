package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import models.Environment;
import utilities.Helper;

public class TestSteps {
    @Given("^I open HCNV app$")
    public void iOpenHCNVApp() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Helper.log(Environment.server.getURL().toString());
    }
}
