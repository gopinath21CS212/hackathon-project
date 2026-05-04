package org.districtappautomation.test.gopinath;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.HomePage;
import org.districtappautomation.test.utility.LoggerUtil;
import org.districtappautomation.test.utility.ScreenshotUtil;
import org.testng.annotations.Test;

public class TC006_NavigateAndValidateEventPage extends BaseClass {
    @Test
    public void navigateAndValidateEventPage() {
        HomePage homePage = new HomePage(driver);
        LoggerUtil.info("Successfully Launched the Application");
        ScreenshotUtil.takeScreenshot(driver);
        homePage.navigateToEvents();
        softAssert.assertTrue(homePage.validatePage("events"),"Event Page Not Found");
        ScreenshotUtil.takeScreenshot(driver);
        LoggerUtil.info("Selected and Validated location Selector Successfully");
    }
}
