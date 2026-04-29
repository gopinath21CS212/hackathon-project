package org.districtappautomation.test;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.SportsPage;
import org.testng.annotations.Test;

import java.util.List;

public class TC004_DisplayListOfSports extends BaseClass {

    @Test
    public void DisplayListOfSports() throws InterruptedException {
        SportsPage sportPage = new SportsPage(driver);
        sportPage.displayListOfSports();
    }
}
