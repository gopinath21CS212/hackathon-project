package org.districtappautomation.test;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.HomePage;
import org.testng.annotations.Test;

public class TC001_NavigateAndValidateEventPage extends BaseClass {

    @Test
    public void navigateAndValidateEventPage() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToEvents();
        Thread.sleep(2000);
        homePage.validateEventPage();
        System.out.println("Selected and Validated location Selector Successfully");
    }
}
