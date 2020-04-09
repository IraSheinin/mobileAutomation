package api.interfaces;

public interface Application {
    Object launchApp();
    String packageID();
    String activityID();
    Integer version();
    void closeApp();

}
