package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.FindBy;

public class WelcomeScreen extends BaseScreen {

    AppiumDriver driver;

    @FindBy(xpath = "//android.widget.TextView[@text='Log in']")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Log in']")
    @iOSFindBy(xpath = "//android.widget.TextView[@text='Log in']")
    MobileElement btnLogin;

    public WelcomeScreen(AppiumDriver driver) {
        super(driver);
    }

    public void clickLogin() {
        clickObject(this.btnLogin);
    }

}
