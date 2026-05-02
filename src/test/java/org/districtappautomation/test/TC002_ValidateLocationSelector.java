package org.districtappautomation.test;

import org.apache.logging.log4j.Logger;
import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.HomePage;
import org.districtappautomation.test.utility.LoggerUtil;
import org.districtappautomation.test.utility.ScreenshotUtil;
import org.testng.annotations.Test;

public class TC002_ValidateLocationSelector extends BaseClass {
    Logger log = LoggerUtil.getLogger(TC002_ValidateLocationSelector.class);
    @Test
    public void ValidateAndSelectCity() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LoggerUtil.info("Successfully Launched the Application");
        Thread.sleep(4000);
        homePage.changeLocationAndValidate("Chennai");
        ScreenshotUtil.takeScreenshot(driver);
        homePage.changeLocationAndValidate("Bangalore");
        ScreenshotUtil.takeScreenshot(driver);
        LoggerUtil.info("Navigated and Validated Event Page Successfully");
    }
}
