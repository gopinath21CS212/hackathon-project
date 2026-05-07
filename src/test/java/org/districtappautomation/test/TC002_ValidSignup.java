package org.districtappautomation.test;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.SignupPage;
import org.districtappautomation.test.utility.ExcelUtils;
import org.districtappautomation.test.utility.LoggerUtil;
import org.testng.annotations.Test;

public class TC002_ValidSignup extends BaseClass {

    @Test
    public void testValidMobileNumber() {
        SignupPage signupPage = new SignupPage(driver);
        Object[][] excelData = ExcelUtils.getTestData("src/main/resources/SignupTestData.xlsx", "MobileNumber");

        for (int i = 0; i < excelData.length; i++) {
            String testType = excelData[i][0].toString();
            String mobileNumber = excelData[i][1].toString();
            if (!"POSITIVE".equalsIgnoreCase(testType)) {
                continue;
            }
            signupPage.openSignupModal();
            signupPage.enterNumberAndSubmit(mobileNumber);

            LoggerUtil.info("Waiting for signup flow response for: " + mobileNumber);
            boolean transitionHappened = signupPage.isOtpScreenDisplayed() || signupPage.isVerificationFlowTriggered();

            softAssert.assertTrue(transitionHappened, "Signup flow did not proceed for valid mobile number: " + mobileNumber);
            LoggerUtil.info("SUCCESS: Signup flow initiated correctly for mobile number: " + mobileNumber);
            signupPage.closeModal();
        }
    }
}