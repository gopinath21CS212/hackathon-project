package org.districtappautomation.test;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.StoresPage;
import org.districtappautomation.test.utility.LoggerUtil;
import org.testng.annotations.Test;

public class TC024_ValidateStoresFlow extends BaseClass {

    @Test
    public void validateStoreDetailsAndTopItems() {
        StoresPage storesPage = new StoresPage(driver);
        LoggerUtil.info("Successfully Launched the Application");
        storesPage.navigateToStoresPage();

        softAssert.assertTrue(driver.getCurrentUrl().contains("stores"),"Not Able to Navigate Store Page");

        storesPage.selectThirdCategory();
        storesPage.selectFourthStore();
        storesPage.printStoreDetailsAndTopItems();
        LoggerUtil.info("The Store was selected and the details were displayed successfully");
    }
}