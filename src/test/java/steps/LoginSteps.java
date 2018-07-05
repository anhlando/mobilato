package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import models.Environment;
import screens.LoginScreen;
import utilities.Helper;

public class LoginSteps {

    LoginScreen loginScreen;

    public LoginSteps(){
        Helper.log("Start LoginSteps class....");
        loginScreen = new LoginScreen(Environment.driver);
        loginScreen.init();
    }


    @When("^I login with phone \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void login_with_account(String phone, String pass) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        loginScreen.login(phone,pass);
    }
}
