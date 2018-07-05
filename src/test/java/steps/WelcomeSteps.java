package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import models.Environment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import screens.WelcomeScreen;
import utilities.Helper;

import java.util.List;

public class WelcomeSteps {

    WelcomeScreen welcomeScreen;

    public WelcomeSteps(){
        Helper.log("WelcomeSteps started....");
        welcomeScreen = new WelcomeScreen(Environment.driver);
        welcomeScreen.init();
    }

    //@And("^I go to login screen$")
    @When("^I go to login screen$")
    public void go_to_login_screen() throws Throwable {
        welcomeScreen.clickLogin();
    }


}
