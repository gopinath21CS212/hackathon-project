package org.districtappautomation.test;

import org.apache.logging.log4j.Logger;
import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.HomePage;
import org.districtappautomation.test.utility.LoggerUtil;
import org.districtappautomation.test.utility.ScreenshotUtil;
import org.testng.annotations.Test;

public class TC0023_ValidateAllNavigatorTabOfHomePage extends BaseClass {
    Logger log = LoggerUtil.getLogger(TC0023_ValidateAllNavigatorTabOfHomePage.class);
    @Test
    public void validateAllNavigatorTabOfHomePage() {
        HomePage homePage = new HomePage(driver);
        LoggerUtil.info("Successfully Launched the Application");
         homePage.navigateToDiningandValidate();
        ScreenshotUtil.takeScreenshot(driver);
         homePage.navigateToMoviesandValidate();
        ScreenshotUtil.takeScreenshot(driver);
         homePage.navigateToEventandValidate();
        ScreenshotUtil.takeScreenshot(driver);
         homePage.navigateToStoresandValidate();
        ScreenshotUtil.takeScreenshot(driver);
         homePage.navigateToActivitiesandValidate();
        ScreenshotUtil.takeScreenshot(driver);
         homePage.navigateToIPLandValidate();
        ScreenshotUtil.takeScreenshot(driver);
        LoggerUtil.info("Successfully Validated All Navigator Tab Of HomePage");
    }
}
