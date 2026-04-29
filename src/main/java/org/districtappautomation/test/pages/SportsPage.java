package org.districtappautomation.test.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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

    public void displayListOfSports() throws InterruptedException {
        eventsTab.click();
        Thread.sleep(3000);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 800);");
        Thread.sleep(3000);
        sportButton.click();
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/events/sports-events"),
                "Sports category was not selected"
        );

        List<WebElement> sportsEvents = driver.findElements(
                By.xpath("//a[contains(@href,'/events/')]//img[@alt]")
        );

        Assert.assertTrue(
                sportsEvents.size() > 0,
                "No sports events are displayed"
        );
        System.out.println("Total Sports Events: " + sportsEvents.size());
        int count = 1;
        for (WebElement event : sportsEvents) {
            String eventName = event.getAttribute("alt");
            if (eventName != null && !eventName.trim().isEmpty()) {
                System.out.println(count + ". " + eventName);
                count++;
            }
        }
    }
}