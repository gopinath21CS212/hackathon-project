package org.districtappautomation.test;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.EventPage;
import org.testng.annotations.Test;

public class TC016_DisplayListOfEvents extends BaseClass {

    @Test
    public void DisplayListOfEvents(){
        EventPage eventPage = new EventPage(driver);
        boolean flag = false;
        String methodResultMessage = eventPage.displayListOfEvents();
        if(methodResultMessage.equals("")){
            flag = true;
        }
        softAssert.assertTrue(flag,methodResultMessage);
    }
}
