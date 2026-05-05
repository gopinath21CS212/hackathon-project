package org.districtappautomation.test.baseclass;

import org.districtappautomation.test.driver.DriverFactory;
import org.districtappautomation.test.utility.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class BaseClass {
    protected WebDriver driver;
    protected SoftAssert softAssert;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        DriverFactory.initDriver(ConfigReader.getProperty("browser"));
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.get(ConfigReader.getBaseUrl());
        softAssert = new SoftAssert();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        try {
            if (softAssert != null) {
                softAssert.assertAll();
            }
        } finally {
            DriverFactory.quitDriver();
        }
    }
}