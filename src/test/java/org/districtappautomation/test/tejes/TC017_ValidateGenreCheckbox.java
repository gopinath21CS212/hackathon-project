package org.districtappautomation.test.tejes;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.MoviePage;
import org.testng.annotations.Test;

public class TC017_ValidateGenreCheckbox extends BaseClass {
    @Test
    public void DisplayGenre() throws InterruptedException{
        MoviePage moviePage=new MoviePage(driver);
        moviePage.display3dGenre();
    }
}
