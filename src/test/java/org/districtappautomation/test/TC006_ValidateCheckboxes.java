package org.districtappautomation.test;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.EventPage;
import org.testng.annotations.Test;

public class TC006_ValidateCheckboxes extends BaseClass {
    @Test
    public void ValidateCheckboxes() throws InterruptedException{
        EventPage eventPage=new EventPage(driver);
        eventPage.checkboxValidation();
    }

}
