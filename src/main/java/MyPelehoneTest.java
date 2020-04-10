import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class MyPelehoneTest {
    public static AndroidDriver<MobileElement> driver;

    public static void main(String [] args){
        try {
            OpenApp();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void OpenApp() throws MalformedURLException, InterruptedException {
        DesiredCapabilities cap = new DesiredCapabilities();
        File app = new File("Pl.apk");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "R58M80728BB");
        cap.setCapability(MobileCapabilityType.UDID,"R58M80728BB");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
        cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
       // cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
      //  cap.setCapability("appPackage", "com.pelephone.launcher");
       // cap.setCapability("appActivity", "com.pelephone.launcher.LauncherButtons");

         cap.setCapability("appPackage", "com.pelephone_mobile");
       //  cap.setCapability("appActivity", "pelephone_mobile.ui.activities.LoginActivity");
        //cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

        URL url = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(url, cap);
        driver.get("https://google.co.il");
        Thread.sleep(10000);
        //driver.findElement(By.xpath("//td[@class='api.android.widget.EditText']")).sendKeys("automation");
        driver.findElement(By.className("api.android.widget.Button")).click();

      /*  Thread.sleep(1000);
        MobileElement button0 = driver.findElement(By.id("com.pelephone.launcher:id/mypelephone"));
        Thread.sleep(1000);
        button0.click();
        //MobileElement button = driver.findElement(By.id("com.api.android.packageinstaller:id/permission_allow_button"));
        //Thread.sleep(500);
        //button.click();
        MobileElement phoneTxt = driver.findElement(By.id("com.pelephone_mobile:id/etEnterPhone"));
        Thread.sleep(1000);
        phoneTxt.setValue("0508270512");*/
        Thread.sleep(30000);
        driver.quit();

    }
}
