package org.districtappautomation.test.chandu;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.SignupPage;
import org.districtappautomation.test.utility.LoggerUtil;
import org.districtappautomation.test.utility.ScreenshotUtil;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC004_InvalidSignupTest extends BaseClass {

    @Test
    public void testShortMobileNumber() {
        SoftAssert softAssert = new SoftAssert();
        SignupPage signupPage = new SignupPage(driver);

        signupPage.openSignupModal();
        signupPage.enterNumberAndSubmit("12345"); // Invalid short number

        String error = signupPage.getErrorText();
        LoggerUtil.info("Captured Error: "+error);
        ScreenshotUtil.takeScreenshot(driver);

        softAssert.assertTrue(
                error.toLowerCase().contains("valid"),
                "Error message not displayed!"
        );

        signupPage.closeModal();
        softAssert.assertAll();
    }
}