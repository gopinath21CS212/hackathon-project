package org.districtappautomation.test.tejes;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.EventPage;
import org.testng.annotations.Test;

public class TC016_DisplayListOfEvents extends BaseClass {

    @Test
    public void DisplayListOfEvents() throws InterruptedException {
        EventPage eventPage = new EventPage(driver);
        eventPage.displayListOfEvents(softAssert);
    }
}
