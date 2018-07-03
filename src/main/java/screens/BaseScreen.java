package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.support.PageFactory;

public class BaseScreen {

    @AndroidFindBy(id="vn.homecredit.hcvn.beta:id/logoWelcomeImageView")
    @iOSFindBy(id="")
    public MobileElement Logo;

    public void test() {
        //PageFactory.
    }
}
