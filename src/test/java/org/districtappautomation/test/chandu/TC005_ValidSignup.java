package org.districtappautomation.test.chandu;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.SignupPage;
import org.districtappautomation.test.utility.LoggerUtil;
import org.districtappautomation.test.utility.ScreenshotUtil;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC005_ValidSignup extends BaseClass {

    @Test
    public void testValidMobileNumber() {
        SoftAssert softAssert = new SoftAssert();
        SignupPage signupPage = new SignupPage(driver);
        signupPage.openSignupModal();
        String validNumber = "9876543210";
        signupPage.enterNumberAndSubmit(validNumber);
        LoggerUtil.info("Waiting for signup flow response...");

        boolean transitionHappened =
                signupPage.isOtpScreenDisplayed()
                        || signupPage.isVerificationFlowTriggered();

        ScreenshotUtil.takeScreenshot(driver);
        softAssert.assertTrue(
                transitionHappened,
                "Signup flow did not proceed after submitting valid mobile number"
        );
        LoggerUtil.info("SUCCESS: Signup flow initiated correctly.");
        signupPage.closeModal();
        softAssert.assertAll();
    }
}