package api.apps.myPelephone;
import api.android.Android;
import api.apps.myPelephone.exitMsgPage.ExitMsgPage;
import api.apps.myPelephone.mainPage.MainPage;
import api.interfaces.Application;
import org.testng.Assert;

public class MyPelephone implements Application {
    MainPage mainPage;

    public void isUpperToolBarAllItemsExist() {
        mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPeleLogoExists());
    }

    public void tapOnMenuItems(){
        mainPage.tapOnSideMenuItems();
    }
    public void confirmExit(){
        mainPage.exit();
    }

    public void isUsedTillNowAllItemsExist() {
    }

    public void isMostUsefulAllItemsExist() {

    }

    public void isSideMenuExist(
    ){
        mainPage.isSideMenuItemsExists();
    };


    public Object launchApp() {
        Android.driver.startActivity(packageID(), activityID());
        return null;
    }
    public String packageID() {
        return "com.pelephone_mobile";
    }
    public String activityID() {
        return "pelephone_mobile.ui.activities.LoginActivity";
    }
    public Integer version() {
        return null;
    }
    public void closeApp() {
        Android.driver.closeApp();
    }

}
