package org.districtappautomation.test.gopinath;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.HomePage;
import org.districtappautomation.test.utility.LoggerUtil;
import org.testng.annotations.Test;

public class TC008_ValidateAllNavigatorTabOfHomePage extends BaseClass {
    @Test
    public void validateAllNavigatorTabOfHomePage() {
        HomePage homePage = new HomePage(driver);
        LoggerUtil.info("Successfully Launched the Application");

        softAssert.assertTrue(homePage.navigateToDiningandValidate(),"Dining Page Not Found");

        softAssert.assertTrue(homePage.navigateToMoviesandValidate(),"Movies Page Not Found");

        softAssert.assertTrue(homePage.navigateToEventandValidate(),"Event Page Not Found");

        softAssert.assertTrue(homePage.navigateToStoresandValidate(),"Stores Page Not Found");

        softAssert.assertTrue(homePage.navigateToActivitiesandValidate(),"Event Page Not Found");

        softAssert.assertTrue(homePage.navigateToIPLandValidate(),"Event Page Not Found");
        LoggerUtil.info("Successfully Validated All Navigator Tab Of HomePage");
    }
}
