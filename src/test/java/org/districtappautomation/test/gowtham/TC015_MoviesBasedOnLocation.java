package org.districtappautomation.test.gowtham;
import org.districtappautomation.test.baseclass.BaseClass;

import org.districtappautomation.test.pages.HomePage;
import org.districtappautomation.test.pages.MoviePage;
import org.districtappautomation.test.utility.LoggerUtil;
import org.testng.annotations.Test;

public class TC015_MoviesBasedOnLocation extends BaseClass {

    @Test
    public void extractMoviesBasedOnLocation() throws InterruptedException {
        MoviePage moviesPage = new MoviePage(driver);
        HomePage homePage = new HomePage(driver);
        LoggerUtil.info("Successfully Launched the Application");
        moviesPage.clickMovies();
        homePage.changeLocationAndValidate("Chennai");
        softAssert.assertTrue(moviesPage.printDisplayeFilterMovieNames(), "FAIL: No movies were found in this Location!");
        LoggerUtil.info("Extracted Movies From Location Test Case Execution Completed");
    }
}