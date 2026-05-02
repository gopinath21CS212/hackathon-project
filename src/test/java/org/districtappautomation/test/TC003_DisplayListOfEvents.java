package org.districtappautomation.test;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.EventPage;
import org.testng.annotations.Test;

public class TC003_DisplayListOfEvents extends BaseClass {

    @Test
    public void DisplayListOfEvents() throws InterruptedException {
        EventPage eventPage = new EventPage(driver);
        eventPage.displayListOfEvents();
    }
}
