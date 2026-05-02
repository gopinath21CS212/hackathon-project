package org.districtappautomation.test;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.EventPage;
import org.testng.annotations.Test;

public class TC005_PriceLowToHigh extends BaseClass {
    @Test
    public void PriceLowToHigh() throws InterruptedException{
        EventPage eventPage=new EventPage(driver);
        eventPage.priceLowToHigh();
    }

}
