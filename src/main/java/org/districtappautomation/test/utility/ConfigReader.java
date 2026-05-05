package org.districtappautomation.test.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;
    static {
        try {
            FileInputStream fis = new FileInputStream(
                    System.getProperty("user.dir")
                            + "/src/main/resources/config/config.properties");

            properties = new Properties();
            properties.load(fis);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file");
        }
    }

    // Generic method to get value
    public static String getBaseUrl() {
        return properties.getProperty("url");
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static WebDriver getBrowser() {
        if(properties.getProperty("browser").equals("chrome")){
            return new ChromeDriver();
        }
        else{
            return new EdgeDriver();
        }
    }
    public static int getExplicitTimeout() {
        return Integer.parseInt(properties.getProperty("explicitwiat"));
    }
}
