package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.support.PageFactory;
import utilities.Helper;

public class BaseScreen {

    AppiumDriver driver;

    public BaseScreen(AppiumDriver driver){
        Helper.log(getClass().toString() + " is constructed");
        this.driver = driver;
    }

    public void init(){
        Helper.log(getClass().toString() + " is initialized");
        PageFactory.initElements(new AppiumFieldDecorator(this.driver),this);
    }

    public void enterValue(MobileElement textbox, String value){
        textbox.clear();
        textbox.sendKeys(value);
    }

    public void clickObject(MobileElement button){
        button.click();
    }

}
