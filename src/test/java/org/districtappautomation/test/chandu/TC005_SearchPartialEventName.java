package org.districtappautomation.test.chandu;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.SearchPage;
import org.districtappautomation.test.utility.LoggerUtil;
import org.testng.annotations.Test;

public class TC005_SearchPartialEventName extends BaseClass {

    @Test
    public void verifySearchUsingSearchBar() {
        SearchPage searchPage = new SearchPage(driver);
        LoggerUtil.info("Executing search flow: open → type → search");
        searchPage.performSearch("Chicken");

        int results = searchPage.getResultsCount();
        LoggerUtil.info("Search results found: " + results);

        softAssert.assertTrue(results > 0, "FAILURE: Search results not displayed");
        LoggerUtil.info("SUCCESS: Search text entered and results displayed");
    }
}