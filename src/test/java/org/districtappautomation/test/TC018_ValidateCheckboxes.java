package org.districtappautomation.test;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.EventPage;
import org.testng.annotations.Test;

public class TC018_ValidateCheckboxes extends BaseClass {
    @Test
    public void ValidateCheckboxes(){
        EventPage eventPage=new EventPage(driver);
        boolean flag = false;
        String methodResultMessage = eventPage.checkboxValidation();
        if(methodResultMessage.equals("")){
            flag = true;
        }
        softAssert.assertTrue(flag,methodResultMessage);
    }
}
