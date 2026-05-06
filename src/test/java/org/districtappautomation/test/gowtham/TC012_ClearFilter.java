package org.districtappautomation.test.gowtham;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.MoviePage;
import org.districtappautomation.test.utility.LoggerUtil;
import org.testng.annotations.Test;

public class TC012_ClearFilter extends BaseClass {

    @Test
    public void verifyClearFilters() {
        MoviePage moviesPage = new MoviePage(driver);
        LoggerUtil.info("Successfully Launched the Application");
        moviesPage.clickMovies();
        moviesPage.openFilters();
        moviesPage.openGenreTab();
        moviesPage.selectFilterOptions("Action", "Adventure");
        moviesPage.applyFilters();
        moviesPage.openFilters();
        moviesPage.clearAllFilters();

        softAssert.assertTrue(moviesPage.areAllFiltersCleared(),"Filters are NOT cleared");
        LoggerUtil.info("ClearFilter Test Case Execution Completed");
    }
}