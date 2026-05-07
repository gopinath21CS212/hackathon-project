package org.districtappautomation.test.pages;

import org.districtappautomation.test.utility.WaitUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class FitnessPage {

    WebDriver driver;

    @FindBy(linkText = "Events")
    WebElement eventsTab;

    @FindBy(xpath = "//a[contains(@href,'/events/fitness-events')]")
    WebElement fitnessButton;

    @FindBy(xpath = "//div[contains(@class,'dds-justify-items-center lg:dds-justify-items-start')]")
    List<WebElement> fitnessEvents;

    public FitnessPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> displayListOfFitness() {
        WaitUtils.waitForElementToBeClickable(driver, eventsTab).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 800);");
        WaitUtils.waitForElementToBeClickable(driver, fitnessButton).click();
        WaitUtils.waitForUrlContains(driver, "/events/fitness-events");
        return fitnessEvents;
    }
}