package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class LoginScreen extends BaseScreen{

    AppiumDriver driver;

    @FindBy(id="vn.homecredit.hcvn.beta:id/phoneNumberTextView")
    MobileElement txtPhone;

    @FindBy(id="vn.homecredit.hcvn.beta:id/passwordTextView")
    MobileElement txtPassword;

    @FindBy(id="vn.homecredit.hcvn.beta:id/email_sign_in_button")
    MobileElement btnLogin;

    public LoginScreen(AppiumDriver driver) {
        super(driver);
    }

    private void enterPhoneNo(String phone){
        enterValue(this.txtPhone,phone);
    }

    private void enterPassword(String pw){
        enterValue(this.txtPassword,pw);
    }

    private void clickLogin(){
        clickObject(this.btnLogin);
    }

    private boolean isFormValid(){
        //TODO: find all error message objects: if found -> form is NOT valid
        return true;
    }

    public void login(String phone, String pass) {
        this.enterPhoneNo(phone);
        this.enterPassword(pass);
        this.clickLogin();
    }
}
