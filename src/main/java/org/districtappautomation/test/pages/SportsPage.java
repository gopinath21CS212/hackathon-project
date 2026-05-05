package org.districtappautomation.test.pages;

import org.districtappautomation.test.utility.LoggerUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import java.util.List;

public class SportsPage {

    WebDriver driver;

    @FindBy(linkText = "Events")
    WebElement eventsTab;

    @FindBy(xpath ="//a[contains(@href,'/events/sports-events')]")
    WebElement sportButton;

    public SportsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void displayListOfSports(SoftAssert softAssert) throws InterruptedException {
        Thread.sleep(3000);
        eventsTab.click();
        Thread.sleep(3000);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 800);");
        Thread.sleep(3000);
        sportButton.click();
        softAssert.assertTrue(driver.getCurrentUrl().contains("/events/sports-events"), "Sports category was not selected");
        List<WebElement> sportsEvents = driver.findElements(By.xpath("//a[contains(@href,'/events/')]//img[@alt]"));
        softAssert.assertTrue(sportsEvents.size() > 0, "No sports events are displayed");
        LoggerUtil.info("Total Sports Events: " + sportsEvents.size());
        int count = 1;
        for (WebElement event : sportsEvents) {
            String eventName = event.getAttribute("alt");
            if (eventName != null && !eventName.trim().isEmpty()) {
                LoggerUtil.info(count + ". " + eventName);
                count++;
            }
        }
    }
}