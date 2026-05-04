package org.districtappautomation.test;

import org.apache.logging.log4j.Logger;
import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.StoresPage;
import org.districtappautomation.test.utility.LoggerUtil;
import org.districtappautomation.test.utility.ScreenshotUtil;
import org.testng.annotations.Test;

public class TC0025_DisplayFootwearBrands extends BaseClass {
    Logger log = LoggerUtil.getLogger(TC0025_DisplayFootwearBrands.class);

    @Test
    public void displayFootwearBrandsInYourCity() {
        StoresPage storesPage = new StoresPage(driver);
        LoggerUtil.info("Successfully Launched the Application");
        storesPage.navigateToStoresPage();
        ScreenshotUtil.takeScreenshot(driver);
        storesPage.navigateToFootwearPage();
        softAssert.assertTrue(storesPage.displayFootwearBrandsInYourCity(),"Footwear list is empty!");
        ScreenshotUtil.takeScreenshot(driver);
        LoggerUtil.info("Successfully Displayed Footwear Brands In Your City");
    }
}
