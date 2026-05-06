package org.districtappautomation.test.gopinath;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.DiningPage;
import org.districtappautomation.test.utility.LoggerUtil;
import org.testng.annotations.Test;

public class TC009_DisplayTrendingMoviesInYourCity extends BaseClass{

    @Test
    public void validateTrendingMoviesInYourCity() {
        DiningPage diningPage = new DiningPage(driver);
        LoggerUtil.info("Successfully Launched the Application");
        diningPage.openDiningTabSearchBox();
        diningPage.navigateToDiningMovieTab();

        softAssert.assertTrue(diningPage.displayTrendingMoviesList(),"Not Able To Fetch Trending Movies List");
        LoggerUtil.info("Successfully Displayed Trending Movies In Your City");
    }
}
