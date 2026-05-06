package org.districtappautomation.test.gopinath;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.StoresPage;
import org.districtappautomation.test.utility.LoggerUtil;
import org.testng.annotations.Test;

public class TC010_DisplayFootwearBrands extends BaseClass {

    @Test
    public void displayFootwearBrandsInYourCity() {
        StoresPage storesPage = new StoresPage(driver);
        LoggerUtil.info("Successfully Launched the Application");
        storesPage.navigateToStoresPage();
        storesPage.navigateToFootwearPage();

        softAssert.assertTrue(storesPage.displayFootwearBrandsInYourCity(),"Footwear list is empty!");
        LoggerUtil.info("Successfully Displayed Footwear Brands In Your City");
    }
}
