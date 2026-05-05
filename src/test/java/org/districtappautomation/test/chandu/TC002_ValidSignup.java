package org.districtappautomation.test.chandu;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.SignupPage;
import org.districtappautomation.test.utility.ExcelUtils;
import org.districtappautomation.test.utility.LoggerUtil;
import org.districtappautomation.test.utility.ScreenshotUtil;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC002_ValidSignup extends BaseClass {

    @Test
    public void testValidMobileNumber() {
        SoftAssert softAssert = new SoftAssert();
        SignupPage signupPage = new SignupPage(driver);
        Object[][] excelData = ExcelUtils.getTestData("src/main/resources/SignupTestData.xlsx", "MobileNumber");
        for (int i = 0; i < excelData.length; i++) {
            String testType = excelData[i][0].toString();
            String mobileNumber = excelData[i][1].toString();
            if (!"POSITIVE".equalsIgnoreCase(testType)) {
                continue; // skip non-positive rows
            }
            signupPage.openSignupModal();
            signupPage.enterNumberAndSubmit(mobileNumber);
            LoggerUtil.info("Waiting for signup flow response for: " + mobileNumber);
            boolean transitionHappened = signupPage.isOtpScreenDisplayed() || signupPage.isVerificationFlowTriggered();
            ScreenshotUtil.takeScreenshot(driver);
            softAssert.assertTrue(transitionHappened, "Signup flow did not proceed for valid mobile number: " + mobileNumber);
            LoggerUtil.info("SUCCESS: Signup flow initiated correctly for mobile number: " + mobileNumber);
            signupPage.closeModal();
        }
        softAssert.assertAll();
    }
}