package org.districtappautomation.test.gowtham;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.MoviePage;

import org.districtappautomation.test.utility.LoggerUtil;
import org.testng.annotations.Test;

import java.util.List;

public class TC005_ExtractMovieLanguagesFromFilter extends BaseClass {

    @Test
    public void extractLanguages() throws InterruptedException {

        MoviePage moviesPage = new MoviePage(driver);
        moviesPage.clickMovies();
        moviesPage.openFilters();
        moviesPage.openLanguageTab();
        List<String> languages = moviesPage.getAvailableLanguages();
        languages.forEach(System.out::println);

        softAssert.assertFalse(languages.isEmpty(),
                "No languages extracted from Language filter");
        LoggerUtil.info("ExtractMovies Test Case Execution Completed");

    }
}