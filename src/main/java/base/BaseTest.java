package base;
import api.android.Android;
import base.managers.AppiumServer;
import base.managers.DriverManager;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.io.IOException;

public class BaseTest {

    @BeforeTest
    public void setUp(){
        AppiumServer.start("0.0.0.0", 4723);
        DriverManager.createDriver("R58M80728BB");

    }

    @AfterTest
    public void tearDown(){
        DriverManager.killDriver();
        AppiumServer.stop();
    }
}
