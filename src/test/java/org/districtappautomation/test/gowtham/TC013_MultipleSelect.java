package org.districtappautomation.test.gowtham;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.MoviePage;

import org.districtappautomation.test.utility.LoggerUtil;
import org.testng.annotations.Test;

public class TC013_MultipleSelect extends BaseClass {

    @Test
    public void multiSelectFilters() throws InterruptedException {

        MoviePage moviesPage = new MoviePage(driver);
        moviesPage.clickMovies();
        moviesPage.openFilters();
        moviesPage.openGenreTab();
        moviesPage.selectFilterOptions("Action", "Adventure");
        moviesPage.openLanguageTab();
        moviesPage.selectFilterOptions("Tamil", "Hindi", "English");
        moviesPage.applyFilters();
        softAssert.assertTrue(moviesPage.printDisplayeFilterMovieNames(),"Filter Not Working Properly");
        LoggerUtil.info("MultipleSelect Test Case Execution Completed");
    }
}