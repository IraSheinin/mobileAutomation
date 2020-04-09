package base.managers;
import api.android.Android;
import base.MyLogger;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class DriverManager {
    private static HashMap<String, URL> hosts;
    private static String unlockPackage= "io.appium.unlock";

    private static DesiredCapabilities getCaps(String deviceID){
        MyLogger.info("Creating driver caps for device: "+deviceID);
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", deviceID);
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.UDID, deviceID);
       // caps.setCapability("userName",
       //         "admin@default.com");
       // caps.setCapability("password", "Pelephone1");
        return caps;
    }
    private static URL host(String deviceID) {
        if(hosts == null){
            hosts = new HashMap<String, URL>();
            try {
                hosts.put("R58M80728BB", new URL("http://0.0.0.0:4723/wd/hub"));
              //  hosts.put("R58M80728BB", AppiumServer.start("127.0.0.1", 4723));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }return hosts.get(deviceID);
    }

    private static ArrayList<String> getAvailableDevices(){
        MyLogger.info("Checking for available devices  ?????");
        return new ArrayList<String>();
    }

    public static void createDriver(String deviceID) {
        MyLogger.info("Trying to create new Driver for device: "+deviceID);
        Android.driver = new AndroidDriver<MobileElement>((host(deviceID)), getCaps(deviceID));
    }

    public static void killDriver(){
        if(Android.driver!=null){
            MyLogger.info("killing android Driver");
            Android.driver.unlockDevice();
            Android.driver.quit();
        }else MyLogger.info("Android driver is not initialized, nothing to kill!");
    }


}