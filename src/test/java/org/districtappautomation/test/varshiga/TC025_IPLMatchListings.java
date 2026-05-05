package org.districtappautomation.test.varshiga;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.IPLPage;
import org.districtappautomation.test.utility.LoggerUtil;
import org.districtappautomation.test.utility.ScreenshotUtil;
import org.testng.annotations.Test;

public class TC025_IPLMatchListings extends BaseClass {
    @Test
    public void displayIplMatchDetails() throws InterruptedException {
        IPLPage iplPage = new IPLPage(driver);
        LoggerUtil.info("Successfully Launched the Application");
        iplPage.navigateToIplPage();
        iplPage.printAvailableTickets();
        ScreenshotUtil.takeScreenshot(driver);
        iplPage.printUpcomingMatches();
        ScreenshotUtil.takeScreenshot(driver);
        LoggerUtil.info("All the Upcoming matches were identified successfully");


    }
}