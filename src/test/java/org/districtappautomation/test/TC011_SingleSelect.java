package org.districtappautomation.test;

import org.districtappautomation.test.baseclass.BaseClass;

import org.districtappautomation.test.pages.MoviePage;
import org.districtappautomation.test.utility.LoggerUtil;
import org.testng.annotations.Test;

public class TC011_SingleSelect extends BaseClass {

    @Test
    public void selectSingleCheckboxAndApplyFilter() {
        MoviePage moviesPage = new MoviePage(driver);
        LoggerUtil.info("Successfully Launched the Application");
        moviesPage.clickMovies();
        moviesPage.openFilters();
        moviesPage.openGenreTab();
        moviesPage.selectFilterOptions("Action");
        moviesPage.applyFilters();
        moviesPage.printDisplayeFilterMovieNames();

        softAssert.assertTrue(moviesPage.printDisplayeFilterMovieNames(),"Filter Not Working Properly");
        LoggerUtil.info("SingleSelect Test Case Execution Completed");
    }
}