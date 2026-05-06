package org.districtappautomation.test.gowtham;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.MoviePage;
import org.districtappautomation.test.utility.LoggerUtil;
import org.testng.annotations.Test;

import java.util.List;

public class TC014_ExtractMovieLanguagesFromFilter extends BaseClass {

    @Test
    public void extractLanguages() {
        MoviePage moviesPage = new MoviePage(driver);
        LoggerUtil.info("Successfully Launched the Application");
        moviesPage.clickMovies();
        moviesPage.openFilters();
        moviesPage.openLanguageTab();

        List<String> languages = moviesPage.getAvailableLanguages();
        for (String language : languages) {
            LoggerUtil.info("Available Language: " + language);
        }

        softAssert.assertFalse(languages.isEmpty(), "No languages extracted from Language filter");
        LoggerUtil.info("ExtractMovies Test Case Execution Completed");
    }
}