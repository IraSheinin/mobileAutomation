package api.apps.myPelephone.mainPage.sideMenu;
import api.apps.myPelephone.MyPelephone;
import api.apps.myPelephone.exitMsgPage.ExitMsgPage;
import base.MyLogger;
import base.UiObject;
import base.UiSelector;

public class SideMenu {
  //  private static MenuUiObjects uiObjects = new MenuUiObjects();
    final String packageID;
    public SideMenu(){
        this.packageID = new MyPelephone().packageID();
    }
  private static UiObject sideMenu,
          myPelephone,
          goodMorning,
          homePage,
          mostUseful,
          servicesAndApps,
          talkToUs,
          setting,
          termsAndConditions,
          about,
          disconnect;

  public UiObject sideMenu(){
      if (sideMenu == null) sideMenu = new UiSelector().resourseId(packageID +":id/menuImage").makeUiObject();
      return sideMenu;
  }

    public UiObject myPelephone(){
        if (myPelephone == null) myPelephone = new UiSelector().textContains("פלאפון שלי").makeUiObject();
        return myPelephone;
    }
    public UiObject goodMorning(){
        if (goodMorning == null) goodMorning = new UiSelector().textContains("טוב").makeUiObject();
        return goodMorning;
    }
    public UiObject homePage(){
        if (homePage == null) homePage = new UiSelector().textContains("מסך הבית").makeUiObject();
        return homePage;
    }
    public UiObject mostUseful(){
        if (mostUseful == null) mostUseful = new UiSelector().textContains("הכי שימושי").makeUiObject();
        return mostUseful;
    }
    public UiObject disconnect(){
        if (disconnect == null) disconnect = new UiSelector().textContains("הכי שימושי").makeUiObject();
        return disconnect;
    }

    public void open(){
        MyLogger.info("Tapping on side Menu");
        sideMenu().tap(10);
    }

    public void isSideMenuExist(){
        MyLogger.info("is Side Menu Exists");
        sideMenu().exists(4);
    }

    public void tapOnHomePage(){
        MyLogger.info("Tapping on side Menu");
        homePage().tap(2);
    }
    public void tapOnMostUseful(){
        MyLogger.info("Tapping on side Menu");
        mostUseful().tap(2);
    }

    public ExitMsgPage tapOnDisconnect(){
        MyLogger.info("Tapping on side Menu");
        disconnect().tap(2);
        return new ExitMsgPage();
    }


}
