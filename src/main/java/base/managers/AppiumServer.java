package base.managers;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.IOException;
import java.net.ServerSocket;

public class AppiumServer{

    private static AppiumDriverLocalService service;
    private static AppiumServiceBuilder builder;
    private static DesiredCapabilities cap;

    public static AppiumDriverLocalService start(String ipAddress, int port) {
        AppiumServer appiumServer = new AppiumServer();
        //Set Capabilities
        if(!appiumServer.checkIfServerIsRunnning(port)) {
            cap = new DesiredCapabilities();
            cap.setCapability("noReset", "false");
            //Build the Appium service
            builder = new AppiumServiceBuilder();
            builder.withIPAddress(ipAddress);
            builder.usingPort(port);
            builder.withCapabilities(cap);
            builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
            builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
            //Start the server with the builder
            service = AppiumDriverLocalService.buildService(builder);
            service.start();
        }
        return service;
    }

    public static void stop() {
        if (!(service ==null)) {
            service.stop();
        }
    }

    public boolean checkIfServerIsRunnning(int port) {
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