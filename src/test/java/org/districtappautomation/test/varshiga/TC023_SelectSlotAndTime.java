package org.districtappautomation.test.varshiga;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.DiningPage;
import org.districtappautomation.test.pages.HomePage;
import org.testng.annotations.Test;

public class TC023_SelectSlotAndTime extends BaseClass {
    @Test
    public void selectSlotAndTimingTest() throws InterruptedException {
        DiningPage diningPage = new DiningPage(driver);
        HomePage homePage = new HomePage(driver);
        softAssert.assertTrue(homePage.changeLocationAndValidate("Bangalore"),"Location Selector is Not Working Properly");
        diningPage.selectSlotTimeAndProceed();
    }
}