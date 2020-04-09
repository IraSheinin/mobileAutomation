package myPelephone;

import api.android.Android;
import base.BaseTest;
import org.testng.annotations.Test;

public class Runner extends BaseTest {

    @Test
    public void mainPageLayout(){
        Android.app.myPelephone.launchApp();
        Android.app.myPelephone.isUpperToolBarAllItemsExist();
        Android.app.myPelephone.tapOnMenuItems();
        Android.app.myPelephone.confirmExit();
        //Android.makeCall("0538207512");
    //     Android.app.myPelephone.isUsedTillNowAllItemsExist();
    //    Android.app.myPelephone.isMostUsefulAllItemsExist();
    }

}



