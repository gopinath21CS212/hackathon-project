package org.districtappautomation.test;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.DiningPage;
import org.testng.annotations.Test;

public class TC008_DisplayRestaurantDetails extends BaseClass {

    @Test
    public void displayRestaurantDetails() throws InterruptedException {

        DiningPage diningPage = new DiningPage(driver);
        diningPage.selectRestaurantAndPrintDetails();
    }
}