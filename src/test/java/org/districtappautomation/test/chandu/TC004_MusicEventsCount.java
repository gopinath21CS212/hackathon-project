package org.districtappautomation.test.chandu;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.MusicEventsPage;
import org.districtappautomation.test.utility.LoggerUtil;
import org.districtappautomation.test.utility.ScreenshotUtil;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC004_MusicEventsCount extends BaseClass {

    @Test
    public void testMusicEventsCount() {
        SoftAssert softAssert = new SoftAssert();
        MusicEventsPage musicPage = new MusicEventsPage(driver);
        LoggerUtil.info("Navigating to Events -> Music...");
        musicPage.navigateToMusicEvents();
        int musicEventsCount = musicPage.getDisplayedEventsCount();
        LoggerUtil.info("Music Events Found: " + musicEventsCount);
        ScreenshotUtil.takeScreenshot(driver);
        softAssert.assertTrue(
                driver.getCurrentUrl().contains("music"),
                "FAILURE: Did not navigate to Music Events page"
        );
        if (musicEventsCount > 0) {
            LoggerUtil.info("SUCCESS: Music events are displayed.");
        } else {
            LoggerUtil.info("INFO: No music events available for this location.");
        }
        softAssert.assertAll();
    }
}