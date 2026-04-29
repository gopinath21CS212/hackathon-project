package org.districtappautomation.test.baseclass;

import org.districtappautomation.test.utility.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = ConfigReader.getBrowser();
        driver.manage().window().maximize();
        driver.get(ConfigReader.getBaseUrl());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
