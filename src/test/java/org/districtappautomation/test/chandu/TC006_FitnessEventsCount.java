package org.districtappautomation.test.chandu;

import org.districtappautomation.test.baseclass.BaseClass;
import org.districtappautomation.test.pages.FitnessPage;
import org.districtappautomation.test.utility.LoggerUtil;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class   TC006_FitnessEventsCount extends BaseClass {

    @Test
    public void DisplayListOfFitness() {

        SoftAssert softAssert = new SoftAssert();

        FitnessPage fitnessPage = new FitnessPage(driver);
        List<WebElement> fitnessEvents = fitnessPage.displayListOfFitness();
        softAssert.assertTrue(
                driver.getCurrentUrl().contains("/events/fitness-events"),
                "Fitness category was not selected"
        );
        softAssert.assertTrue(
                fitnessEvents.size() > 0,
                "No fitness events are displayed"
        );
        LoggerUtil.info("Total Fitness Events: " + fitnessEvents.size());
        int count = 1;
        for (WebElement event : fitnessEvents) {
            String eventName = event.getAttribute("alt");
            if (eventName != null && !eventName.trim().isEmpty()) {
                System.out.println(count + ". " + eventName);
                count++;
            }
        }
        softAssert.assertAll();
    }
}