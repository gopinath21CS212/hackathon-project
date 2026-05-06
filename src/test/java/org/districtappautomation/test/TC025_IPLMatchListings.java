package org.districtappautomation.test;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.IPLPage;
import org.districtappautomation.test.utility.LoggerUtil;
import org.testng.annotations.Test;

public class TC025_IPLMatchListings extends BaseClass {
    @Test
    public void displayIplMatchDetails(){
        IPLPage iplPage = new IPLPage(driver);
        LoggerUtil.info("Successfully Launched the Application");
        iplPage.navigateToIplPage();

        softAssert.assertTrue(driver.getCurrentUrl().contains("ipl-ticket-booking"),"Not Able to Navigate IPL Page");

        iplPage.printAvailableTickets();
        iplPage.printUpcomingMatches();
        LoggerUtil.info("All the Upcoming matches were identified successfully");
    }
}