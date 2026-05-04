package org.districtappautomation.test.gopinath;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.DiningPage;
import org.districtappautomation.test.utility.LoggerUtil;
import org.districtappautomation.test.utility.ScreenshotUtil;
import org.testng.annotations.Test;

public class TC009_DisplayTrendingMoviesInYourCity extends BaseClass{

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
