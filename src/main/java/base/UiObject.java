package base;
import api.android.Android;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.sound.midi.Soundbank;
import java.util.NoSuchElementException;


public class UiObject {
    private String locator="";

    UiObject(String locator){
        this.locator=locator;
        MyLogger.debug("Create new UiObject: "+ this.locator);
    }
    private boolean isXpath(){
        return !locator.contains("UiSelector");
    }

    public boolean exists(int seconds) {
        WebElement element = null;
        Timer timer = new Timer();
        timer.start();
        while(!timer.expired(seconds)) {
            try {
                if (isXpath()) element = Android.driver.findElementByXPath(locator);
                else element = Android.driver.findElementByAndroidUIAutomator(locator);
                return element.isDisplayed();
            }
            catch (Exception e){
            }
        }
        return false;
    }

    public boolean isChecked(){
        try {
            WebElement element;
            if(isXpath()) element = Android.driver.findElementByXPath(locator);
            else element = Android.driver.findElementByAndroidUIAutomator(locator);
            return element.getAttribute("checked").equals("true");
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isCheckable(){
        try {
            WebElement element;
            if(isXpath()) element = Android.driver.findElementByXPath(locator);
            else element = Android.driver.findElementByAndroidUIAutomator(locator);
            return element.getAttribute("checkable").equals("true");
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean isClickable(){
        try {
            WebElement element;
            if(isXpath()) element = Android.driver.findElementByXPath(locator);
            else element = Android.driver.findElementByAndroidUIAutomator(locator);
            return element.getAttribute("clickable").equals("true");
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isEnabled(){
        try {
            WebElement element;
            if(isXpath()) element = Android.driver.findElementByXPath(locator);
            else element = Android.driver.findElementByAndroidUIAutomator(locator);
            return element.getAttribute("enabled").equals("true");
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isFocusable(){
        try {
            WebElement element;
            if(isXpath()) element = Android.driver.findElementByXPath(locator);
            else element = Android.driver.findElementByAndroidUIAutomator(locator);
            return element.getAttribute("focusable").equals("true");
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean isFocused(){
        try {
            WebElement element;
            if(isXpath()) element = Android.driver.findElementByXPath(locator);
            else element = Android.driver.findElementByAndroidUIAutomator(locator);
            return element.getAttribute("focused").equals("true");
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isScrollable(){
        try {
            WebElement element;
            if(isXpath()) element = Android.driver.findElementByXPath(locator);
            else element = Android.driver.findElementByAndroidUIAutomator(locator);
            return element.getAttribute("scrollable").equals("true");
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean isLongClickable(){
        try {
            WebElement element;
            if(isXpath()) element = Android.driver.findElementByXPath(locator);
            else element = Android.driver.findElementByAndroidUIAutomator(locator);
            return element.getAttribute("longClickable").equals("true");
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean isSelected(){
        try {
            WebElement element;
            if(isXpath()) element = Android.driver.findElementByXPath(locator);
            else element = Android.driver.findElementByAndroidUIAutomator(locator);
            return element.getAttribute("selected").equals("true");
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public Point getLocation(){
        WebElement element;
        if(isXpath()) element = Android.driver.findElementByXPath(locator);
        else element = Android.driver.findElementByAndroidUIAutomator(locator);
        return element.getLocation();
    }

    public String getText(){
        WebElement element;
        if(isXpath()) element = Android.driver.findElementByXPath(locator);
        else element = Android.driver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("name");
    }
    public String getResourseId(){
        WebElement element;
        if(isXpath()) element = Android.driver.findElementByXPath(locator);
        else element = Android.driver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("resourseId");
    }
    public String getClassName(){
        WebElement element;
        if(isXpath()) element = Android.driver.findElementByXPath(locator);
        else element = Android.driver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("className");
    }

    public String getContentDesc(){
        WebElement element;
        if(isXpath()) element = Android.driver.findElementByXPath(locator);
        else element = Android.driver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("contentDesc");
    }

    public UiObject clearText(){
        if(isXpath()) Android.driver.findElementByXPath(locator).clear();
        else Android.driver.findElementByAndroidUIAutomator(locator).clear();
        return this;
    }
    public UiObject typeText(String value){
        if(isXpath()) Android.driver.findElementByXPath(locator).sendKeys(value);
        else Android.driver.findElementByAndroidUIAutomator(locator).sendKeys(value);
        return this;
    }

    public UiObject tap(int seconds){
        WebDriverWait wait = new WebDriverWait(Android.driver, seconds);
        if(isXpath())
            wait.until(ExpectedConditions.elementToBeClickable(Android.driver.findElementByXPath(locator))).click();
        else
            wait.until(ExpectedConditions.elementToBeClickable(Android.driver.findElementByAndroidUIAutomator(locator))).click();
        return this;
    }
    public UiObject waitToAppear(int seconds){
        Timer timer = new Timer();
        timer.start();
        while(!timer.expired(seconds)) if (exists(0)) break;
        if (timer.expired(seconds) && !exists(0) )
            throw new AssertionError("Element failed to appear within " + seconds+" seconds");
        return this;
    }

    public UiObject waitToDisappear(int seconds){
        Timer timer = new Timer();
        timer.start();
        while(!timer.expired(seconds)) if (!exists(0)) break;
        if (timer.expired(seconds) && exists(0) )
            throw new AssertionError("Element failed to disappear within " + seconds+" seconds");
        return this;
    }
}
