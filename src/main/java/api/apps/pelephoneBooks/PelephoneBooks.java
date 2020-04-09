package api.apps.pelephoneBooks;
import api.android.Android;
import api.apps.myPelephone.mainPage.sideMenu.SideMenu;
import api.interfaces.Application;

public class PelephoneBooks implements Application {
    public SideMenu mainPageMenu = new SideMenu();

    public Object launchApp() {
        Android.driver.startActivity(packageID(), activityID());
        return null;
    }
    public String packageID() {
        return "com.getbooks.android";
    }
    public String activityID() {
        return "com.getbooks.android.ui.activities.splash.SplashActivity";
    }
    public Integer version() {
        return null;
    }
    public void closeApp() {
        Android.driver.closeApp();
    }
}
