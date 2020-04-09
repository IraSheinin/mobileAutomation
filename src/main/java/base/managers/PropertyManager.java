package base.managers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    Properties prop;
    public  PropertyManager(String propertyFilePath){
        prop = new Properties();
        try {
            prop.load(new FileInputStream(propertyFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  String getConfigData(String propertyName) {
        return prop.getProperty(propertyName);
    }

}