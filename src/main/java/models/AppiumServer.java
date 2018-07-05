package models;

import gherkin.lexer.He;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilities.Helper;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;

public class AppiumServer {
    private AppiumDriverLocalService service;
    private AppiumServiceBuilder builder;
    private DesiredCapabilities cap;

    private int portMin;
    private int portMax;
    private String ip;

    public AppiumServer(String ip, int portMin, int portMax) {
        this.ip = ip;
        this.portMin = portMin;
        this.portMax = portMax;
        Helper.log("Init the appium server...");
    }

    public void startServer() {
        try {
            //Set Capabilities
            cap = new DesiredCapabilities();
            cap.setCapability("noReset", "false");
            cap.setCapability("--session-override", true);

            //Build the Appium service
            builder = new AppiumServiceBuilder();
            builder.withIPAddress(ip);
            Helper.log("Appium server ip: " + ip);

            int port = getAvailablePort();
            Helper.log("Appium server port: " + port);
            builder.usingPort(port);

            builder.withCapabilities(cap);
            builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");

            //Start the server with the builder
            service = AppiumDriverLocalService.buildService(builder);
            service.start();
            Helper.log("Appium server started successfully at: " + getURL());
        } catch (Exception e) {
            Helper.log("Error: " + e.getMessage());
            Helper.log("Stack trace: " + e.getStackTrace());
        }
    }

    public void stopServer() {
        service.stop();
        Helper.log("Appium server stopped successfully!!!");
    }

    public URL getURL() {
        if (service.isRunning()) {
            return service.getUrl();
        } else {
            return null;
        }
    }

    private int getAvailablePort() {
        //find available port
        boolean isPortAvailable = false;
        int port = 0;
        while (!isPortAvailable) {
            port = Helper.genRandomNumber(portMin, portMax);
            isPortAvailable = !checkIfServerIsRunnning(port);
        }
        return port;
    }

    private boolean checkIfServerIsRunnning(int port) {
        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            //If control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }

}
