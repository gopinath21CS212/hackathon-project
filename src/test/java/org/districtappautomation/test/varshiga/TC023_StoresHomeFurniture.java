package org.districtappautomation.test.varshiga;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.StoresPage;
import org.districtappautomation.test.utility.LoggerUtil;
import org.districtappautomation.test.utility.ScreenshotUtil;
import org.testng.annotations.Test;

public class TC023_StoresHomeFurniture extends BaseClass {

    @Test
    public void validateHomeFurnitureStores() throws InterruptedException {
        StoresPage storesPage = new StoresPage(driver);
        LoggerUtil.info("Successfully Launched the Application");
        storesPage.navigateToStoresPage();
        storesPage.selectHomeFurnitureCategory();
        softAssert.assertTrue(driver.getCurrentUrl().contains("furniture"),"Not Able to Navigate to Furniture Tab");
        ScreenshotUtil.takeScreenshot(driver);
        storesPage.printAllStoreNames();
        ScreenshotUtil.takeScreenshot(driver);
        LoggerUtil.info("All the Upcoming matches were identified successfully");
    }
}