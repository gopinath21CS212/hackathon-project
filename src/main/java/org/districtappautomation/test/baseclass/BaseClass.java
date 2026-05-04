package org.districtappautomation.test.baseclass;

import org.districtappautomation.test.utility.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class BaseClass {

    protected WebDriver driver;
    protected SoftAssert softAssert;

    @BeforeMethod
    public void setUp() {
        driver = ConfigReader.getBrowser();
        driver.manage().window().maximize();
        driver.get(ConfigReader.getBaseUrl());
        softAssert = new SoftAssert();

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        softAssert.assertAll();
    }
}
