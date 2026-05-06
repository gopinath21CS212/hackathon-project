package org.districtappautomation.test.baseclass;

import org.districtappautomation.test.driver.DriverFactory;
import org.districtappautomation.test.utility.ConfigReader;
import org.districtappautomation.test.utility.LoggerUtil;
import org.districtappautomation.test.utility.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
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
    public void tearDown(ITestResult result) {
        try {
            //code for SS and Result ITestResult
            if (driver != null) {
                String testName = result.getTestClass()
                        .getRealClass()
                        .getSimpleName();

                if (result.getStatus() == ITestResult.FAILURE) {
                    ScreenshotUtil.takeScreenshot(driver, testName + "_FAILED");
                    LoggerUtil.error("Test case failed.");
                } else if (result.getStatus() == ITestResult.SUCCESS) {
                    ScreenshotUtil.takeScreenshot(driver, testName + "_PASSED");
                    LoggerUtil.info("Test case passed.");
                }
                LoggerUtil.info("Screenshot captured for test: "+testName);
            }
        } catch (Exception e) {
            LoggerUtil.error("Error while taking screenshot: "+e.getMessage());
        } finally {
            if (driver != null) {
                LoggerUtil.info("Closing the browser");
                driver.quit();
                driver = null;
            }
            if (softAssert != null) {
                softAssert.assertAll();
            }
        }
    }
}