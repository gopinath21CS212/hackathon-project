package org.districtappautomation.test;

import org.apache.logging.log4j.Logger;
import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.DiningPage;
import org.districtappautomation.test.utility.LoggerUtil;
import org.districtappautomation.test.utility.ScreenshotUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC0024_DisplayTrendingMoviesInYourCity  extends BaseClass{
    Logger log = LoggerUtil.getLogger(TC0024_DisplayTrendingMoviesInYourCity.class);

    @Test
    public void validateTrendingMoviesInYourCity() throws InterruptedException {
        DiningPage diningPage = new DiningPage(driver);
        LoggerUtil.info("Successfully Launched the Application");
        diningPage.openDiningTabSearchBox();
        ScreenshotUtil.takeScreenshot(driver);
        diningPage.navigateToDiningMovieTab();
        softAssert.assertTrue(diningPage.displayTrendingMoviesList(),"Trending movies list is empty!");
        ScreenshotUtil.takeScreenshot(driver);
        LoggerUtil.info("Successfully Displayed Trending Movies In Your City");
    }
}
