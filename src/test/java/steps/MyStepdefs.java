package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MyStepdefs {

    DesiredCapabilities caps;
    AppiumDriver<MobileElement> driver;

    @Given("^I open HCNV app$")
    public void iOpenHCNVApp() throws Throwable {

        caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "My Phone");
        caps.setCapability("udid", "SH442WM09501");

        caps.setCapability("platformName", "Android");

        caps.setCapability("noReset", "true");
        caps.setCapability("appPackage", "vn.homecredit.hcvn.beta");
        caps.setCapability("appActivity", "vn.homecredit.hcvn.ui.welcome.WelcomeActivity");

        try {
            //driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
            driver = new AppiumDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
            System.out.println("Test started");
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
        //Instantiate Appium Driver

    }

    @And("^I do sth$")
    public void iDoSth() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
