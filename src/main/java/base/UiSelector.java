package base;

public class UiSelector {

    private String locator = "new UiSelector()";


    public UiSelector resourseId(String value){
        locator += ".resourceId(\"" +value +"\")";
        MyLogger.info(locator);
        return this;
    }

    public UiSelector className(String value){
        locator += ".className(\"" +value +"\")";
        return this;
    }

    public UiSelector classNameMatches(String regex){
        locator += ".classNameMatches(\"" +regex +"\")";
        return this;
    }
    public UiSelector text(String value){
        locator += ".text(\"" +value +"\")";
        System.out.println(locator);
        return this;
    }
    public UiSelector textContains(String value){
        locator += ".textContains(\"" +value +"\")";
        return this;
    }

    public UiSelector index(int value){
        locator += ".index("+ value+")";
        return this;
    }

    public UiSelector clickable(boolean value){
        locator += ".clickable(" +value +")";
        return this;
    }

    public UiSelector checked(boolean value){
        locator += ".checked(" +value +")";
        return this;
    }
    public UiSelector enabled(boolean value){
        locator += ".enabled(" +value +")";
        return this;
    }

    public UiSelector desription(String value){
        locator += ".desription(\"" +value +"\")";
        return this;
    }
    public UiSelector desriptionContains(String value){
        locator += ".desriptionContains(\"" +value +"\")";
        return this;
    }

    public UiSelector desriptionMatches(String regex){
        locator += ".desriptionMatches(\"" +regex +"\")";
        return this;
    }

    public UiSelector xPath(String xPath){
        locator = xPath;
        System.out.println(locator);
        return this;
    }

    public UiObject makeUiObject(){
        return new UiObject(locator);
    }
}
