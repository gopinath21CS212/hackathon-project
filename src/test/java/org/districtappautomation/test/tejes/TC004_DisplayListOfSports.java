package org.districtappautomation.test.tejes;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.SportsPage;
import org.testng.annotations.Test;

public class TC004_DisplayListOfSports extends BaseClass {

    @Test
    public void DisplayListOfSports() throws InterruptedException {
        SportsPage sportPage = new SportsPage(driver);
        sportPage.displayListOfSports();
    }
}
