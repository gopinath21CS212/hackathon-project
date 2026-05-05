package org.districtappautomation.test.gowtham;

import org.districtappautomation.test.baseclass.BaseClass;

import org.districtappautomation.test.pages.MoviePage;
import org.districtappautomation.test.utility.LoggerUtil;
import org.testng.annotations.Test;

public class TC011_SingleSelect extends BaseClass {

    @Test
    public void selectSingleCheckboxAndApplyFilter() {
        MoviePage moviesPage = new MoviePage(driver);
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