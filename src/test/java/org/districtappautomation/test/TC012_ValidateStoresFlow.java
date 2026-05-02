package org.districtappautomation.test;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.StoresPage;
import org.testng.annotations.Test;

public class TC012_ValidateStoresFlow extends BaseClass {

    @Test
    public void validateStoreDetailsAndTopItems() {
        StoresPage storesPage = new StoresPage(driver);
        storesPage.navigateToStoresPage();
        storesPage.selectThirdCategory();
        storesPage.selectFourthStore();
        storesPage.printStoreDetailsAndTopItems();
    }
}