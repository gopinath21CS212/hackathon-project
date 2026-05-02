package org.districtappautomation.test;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.DiningPage;
import org.testng.annotations.Test;

public class TC009_DisplayAboutRestaurantDetails extends BaseClass {
    @Test
    public void displayAboutRestaurantDetails() throws InterruptedException {
        DiningPage diningPage = new DiningPage(driver);
        diningPage.printAboutRestaurantDetails();
    }
}