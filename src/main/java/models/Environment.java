package models;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilities.Helper;
import utilities.Settings;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class Environment {

    public static AppiumServer server;
    public static AppiumDriver driver;
    public static DesiredCapabilities caps;
    public static Properties properties;
    public static Properties settings;

    public void initialize() {
        //get environment properties
        generateProperties();
        //get settings
        generateSettings();
        //get caps
        generateCap();

        //start Appium server
        server = new AppiumServer(settings.getProperty("appium.ip"),
                                Integer.parseInt(settings.getProperty("appium.minPort")),
                                Integer.parseInt(settings.getProperty("appium.maxPort")));
        server.startServer();

        //Generate new driver
        DriverFactory driverFactory = new DriverFactory(server.getURL(),caps);
        driver = driverFactory.getDriver(properties.getProperty("platform"));

    }

    public static void cleanup() {
        server.stopServer();
    }

    private void generateProperties() {
        InputStream inputStream = null;
        try {
            this.properties = new Properties();
            String propFileName = "environment.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            this.properties.load(inputStream);
            inputStream.close();

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }

    }

    private void generateSettings() {
        InputStream inputStream = null;
        try {
            this.settings = new Properties();
            String propFileName = "settings.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            this.settings.load(inputStream);
            inputStream.close();

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    private void generateCap() {
        caps = new DesiredCapabilities();
        caps.setCapability("deviceName", properties.getProperty("deviceName"));
        caps.setCapability("udid",properties.getProperty("deviceID"));
        caps.setCapability("platformName", properties.getProperty("platform"));
        caps.setCapability("platformVersion", properties.getProperty("os_version"));
        caps.setCapability("noReset", "true");
        caps.setCapability("appPackage", properties.getProperty("app_package"));
        caps.setCapability("appActivity", properties.getProperty("app_activity"));
    }


}
