package org.districtappautomation.test.varshiga;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.DiningPage;
import org.districtappautomation.test.utility.LoggerUtil;
import org.districtappautomation.test.utility.ScreenshotUtil;
import org.testng.annotations.Test;

public class TC022_DisplayAboutRestaurantDetails extends BaseClass {
    @Test
    public void displayAboutRestaurantDetails() throws InterruptedException {
        DiningPage diningPage = new DiningPage(driver);
        LoggerUtil.info("Successfully Launched the Application");
        diningPage.printAboutRestaurantDetails();
        ScreenshotUtil.takeScreenshot(driver);
        LoggerUtil.info("Restaurant details were retrieved successfully");
    }
}