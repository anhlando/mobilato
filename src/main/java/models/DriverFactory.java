package models;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class DriverFactory {

    private URL url;
    private DesiredCapabilities cap;

    public DriverFactory(URL url, DesiredCapabilities cap) {
        this.url = url;
        this.cap = cap;
    }

    public AppiumDriver getDriver(String platform) {
        if (platform.trim().toUpperCase().equals("ANDROID"))
            return new AndroidDriver(this.url, this.cap);
        else if (platform.trim().toUpperCase().equals("IOS"))
            return new IOSDriver(this.url, this.cap);
        else
            return null;

    }

}
