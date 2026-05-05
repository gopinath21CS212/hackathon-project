package org.districtappautomation.test.varshiga;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.StoresPage;
import org.districtappautomation.test.utility.LoggerUtil;
import org.districtappautomation.test.utility.ScreenshotUtil;
import org.testng.annotations.Test;

public class TC024_ValidateStoresFlow extends BaseClass {

    @Test
    public void validateStoreDetailsAndTopItems() {
        StoresPage storesPage = new StoresPage(driver);
        LoggerUtil.info("Successfully Launched the Application");
        storesPage.navigateToStoresPage();
        storesPage.selectThirdCategory();
        ScreenshotUtil.takeScreenshot(driver);
        storesPage.selectFourthStore();
        ScreenshotUtil.takeScreenshot(driver);
        storesPage.printStoreDetailsAndTopItems();
        ScreenshotUtil.takeScreenshot(driver);
        LoggerUtil.info("The Store was selected and the details were displayed successfully");
    }
}