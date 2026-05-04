package org.districtappautomation.test;

import org.apache.logging.log4j.Logger;
import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.MoviePage;
import org.districtappautomation.test.utility.LoggerUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC007_ClearFilter extends BaseClass {

    @Test
    public void verifyClearFilters() throws InterruptedException {
        MoviePage moviesPage = new MoviePage(driver);
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