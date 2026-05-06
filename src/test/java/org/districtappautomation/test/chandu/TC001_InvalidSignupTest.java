package org.districtappautomation.test.chandu;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.SignupPage;
import org.districtappautomation.test.utility.ExcelUtils;
import org.districtappautomation.test.utility.LoggerUtil;
import org.testng.annotations.Test;

public class TC001_InvalidSignupTest extends BaseClass {

    @Test
    public void testShortMobileNumber() {
        SignupPage signupPage = new SignupPage(driver);
        Object[][] excelData =  ExcelUtils.getTestData("src/main/resources/SignupTestData.xlsx", "MobileNumber");
        signupPage.openSignupModal();

        for(int i = 0; i < excelData.length; i++){
            if(!("POSITIVE".equalsIgnoreCase(excelData[i][0].toString()))){
                signupPage.enterNumberAndSubmit((String)excelData[i][1]);
                String error = signupPage.getErrorText();
                LoggerUtil.info("Captured Error: "+error);
                softAssert.assertTrue(error.toLowerCase().contains("valid"), "Error message not displayed!");
            }
        }
        signupPage.closeModal();
    }
}