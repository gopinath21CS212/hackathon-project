package org.districtappautomation.test;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.HomePage;
import org.districtappautomation.test.utility.LoggerUtil;
import org.districtappautomation.test.utility.ScreenshotUtil;
import org.testng.annotations.Test;

import org.apache.logging.log4j.Logger;

public class TC001_NavigateAndValidateEventPage extends BaseClass {
    Logger log = LoggerUtil.getLogger(TC001_NavigateAndValidateEventPage.class);
    @Test
    public void navigateAndValidateEventPage() {
        HomePage homePage = new HomePage(driver);
        LoggerUtil.info("Successfully Launched the Application");
        ScreenshotUtil.takeScreenshot(driver);
        homePage.navigateToEvents();
        homePage.validatePage("events");
        ScreenshotUtil.takeScreenshot(driver);
        LoggerUtil.info("Selected and Validated location Selector Successfully");
    }
}
