package org.districtappautomation.test.gopinath;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.HomePage;
import org.districtappautomation.test.utility.LoggerUtil;
import org.districtappautomation.test.utility.ScreenshotUtil;
import org.testng.annotations.Test;

public class TC007_ValidateLocationSelector extends BaseClass {
    @Test
    public void ValidateAndSelectCity() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LoggerUtil.info("Successfully Launched the Application");
        Thread.sleep(4000);

        softAssert.assertTrue(homePage.changeLocationAndValidate("Chennai"),"Location Selector is Not Working Properly");

        softAssert.assertTrue(homePage.changeLocationAndValidate("Bangalore"),"Location Selector is Not Working Properly");
        LoggerUtil.info("Navigated and Validated Event Page Successfully");
    }
}
