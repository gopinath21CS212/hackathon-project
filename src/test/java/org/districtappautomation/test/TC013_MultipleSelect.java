package org.districtappautomation.test;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.MoviePage;

import org.districtappautomation.test.utility.LoggerUtil;
import org.testng.annotations.Test;

public class TC013_MultipleSelect extends BaseClass {

    @Test
    public void multiSelectFilters() {
        MoviePage moviesPage = new MoviePage(driver);
        LoggerUtil.info("Successfully Launched the Application");
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