package api.apps.myPelephone.mainPage;

import api.apps.myPelephone.MyPelephone;
import api.apps.myPelephone.exitMsgPage.ExitMsgPage;
import api.apps.myPelephone.mainPage.sideMenu.SideMenu;
import api.apps.myPelephone.mainPage.mostUsefulLinks.MostUsefulLinks;
import base.UiObject;
import base.UiSelector;

public class MainPage {
    final String packageID;
    final SideMenu sideMenu;
    private static UiObject peleLogo;

    public MostUsefulLinks mostUsefulLinks = new MostUsefulLinks();

    public MainPage(){
        packageID = new MyPelephone().packageID();
        sideMenu = new SideMenu();
    }


    public UiObject peleLogo(){
        if (peleLogo == null) peleLogo = new UiSelector().resourseId(packageID +":id/headerLogo").makeUiObject();
        return peleLogo;
    }
    public boolean isPeleLogoExists(){
        return peleLogo().exists(15);
    }
    public void clickOnMostUsefulLinks(){

    }
    public void isSideMenuItemsExists(){
        sideMenu.isSideMenuExist();
    }

    public void tapOnSideMenuItems(){
        sideMenu.open();
        sideMenu.tapOnHomePage();
        sideMenu.open();
        sideMenu.mostUseful();
        sideMenu.open();
    }
    public void exit(){
        ExitMsgPage exitMsgPage;
        sideMenu.open();
        exitMsgPage = sideMenu.tapOnDisconnect();
        exitMsgPage.confirmExit();
    }

}
