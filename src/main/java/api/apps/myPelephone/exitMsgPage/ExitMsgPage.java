package api.apps.myPelephone.exitMsgPage;

import api.apps.myPelephone.MyPelephone;
import base.UiObject;
import base.UiSelector;

public class ExitMsgPage {
    final String packageID;
    public ExitMsgPage(){
        this.packageID = new MyPelephone().packageID();
    }
    private static UiObject confirmBtn, cancelBtn;

    public void confirmExit(){
        confirmBtn().tap(1);
    }

    public void cancelExit(){
        cancelBtn().tap(1);

    }
    private UiObject confirmBtn(){
        if (confirmBtn == null) confirmBtn = new UiSelector().resourseId(packageID +":id/generalDialogConfirmBtn").makeUiObject();
        return confirmBtn;
    }

    private UiObject cancelBtn(){
        if (cancelBtn == null) cancelBtn = new UiSelector().resourseId(packageID +":id/dialogCancelBtn").makeUiObject();
        return cancelBtn;
    }


}
