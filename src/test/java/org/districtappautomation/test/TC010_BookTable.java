package org.districtappautomation.test;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.DiningPage;
import org.districtappautomation.test.pages.HomePage;
import org.testng.annotations.Test;

public class TC010_BookTable extends BaseClass {

    @Test
    public void bookTableTest() throws InterruptedException {
        DiningPage diningPage = new DiningPage(driver);
        HomePage homePage = new HomePage(driver);
        homePage.changeLocationAndValidate("Bangalore");
        diningPage.bookTableAndPrintSelection();
    }
}
