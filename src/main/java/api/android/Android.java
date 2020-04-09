package api.android;

import api.apps.Apps;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class Android {
    public static AndroidDriver driver;
    public static Apps app = new Apps();
    static final String packageName = "com.samsung.android.dialer";

    public static void makeCall(String phoneNumber){
        driver.startActivity(packageName, "DialtactsActivity");
        driver.findElement(By.id(packageName+":id/dialer_menu_search")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id(packageName+":id/search_src_text")).sendKeys("Becky");

        //driver.startActivity("com.android.dialer", "DialtactsActivity");
        //driver.findElement(By.id("com.android.dialer:id/search_view")).sendKeys("Becky");
    }
}
