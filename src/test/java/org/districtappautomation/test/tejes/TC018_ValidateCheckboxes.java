package org.districtappautomation.test.tejes;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.EventPage;
import org.testng.annotations.Test;

public class TC018_ValidateCheckboxes extends BaseClass {
    @Test
    public void ValidateCheckboxes(){
        EventPage eventPage=new EventPage(driver);
        eventPage.checkboxValidation(softAssert);
    }
}
