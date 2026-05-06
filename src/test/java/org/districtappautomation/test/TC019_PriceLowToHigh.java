package org.districtappautomation.test;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.EventPage;
import org.testng.annotations.Test;

public class TC019_PriceLowToHigh extends BaseClass {
    @Test
    public void PriceLowToHigh(){
        EventPage eventPage=new EventPage(driver);
        boolean flag = false;
        String methodResultMessage = eventPage.priceLowToHigh();
        if(methodResultMessage.equals("")){
            flag = true;
        }
        softAssert.assertTrue(flag,methodResultMessage);
    }
}
