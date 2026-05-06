package org.districtappautomation.test.pages;

import org.districtappautomation.test.utility.LoggerUtil;
import org.districtappautomation.test.utility.WaitUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class SportsPage {

    WebDriver driver;

    @FindBy(linkText = "Events")
    WebElement eventsTab;

    @FindBy(xpath ="//a[contains(@href,'/events/sports-events')]")
    WebElement sportButton;

    @FindBy(xpath ="//a[contains(@href,'/events/')]//img[@alt]")
    List<WebElement> sportsEvents;

    public SportsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String displayListOfSports() {
        LoggerUtil.info("TestCase_20 Started");

        WaitUtils.waitForElementToBeClickable(driver,eventsTab);
        eventsTab.click();

        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 800);");
        WaitUtils.waitForElementToBeClickable(driver,sportButton);
        sportButton.click();

        if(!driver.getCurrentUrl().contains("/events/sports-events")){
            return "Sports category was not selected";
        }

        if(!(sportsEvents.size() > 0)){
            return "No sports events are displayed";
        }
        LoggerUtil.info("Total Sports Events: " + sportsEvents.size());

        int count = 1;
        for (WebElement event : sportsEvents) {
            String eventName = event.getAttribute("alt");
            if (eventName != null && !eventName.trim().isEmpty()) {
                LoggerUtil.info(count + ". " + eventName);
                count++;
            }
        }

        LoggerUtil.info("TestCase_20 Execution Successful");
        return "";
    }
}