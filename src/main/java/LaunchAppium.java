import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class LaunchAppium {
    public static AndroidDriver<MobileElement> driver;
    public static MobileDriver<MobileElement> driver2;

    public static void main(String[] arg){
        DesiredCapabilities cap = new DesiredCapabilities();
        File app = new File("Pl.apk");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "R58M80728BB");
        cap.setCapability(MobileCapabilityType.UDID,"R58M80728BB");

        cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"9");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        //cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        try {
            driver = new AndroidDriver <MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }


}
