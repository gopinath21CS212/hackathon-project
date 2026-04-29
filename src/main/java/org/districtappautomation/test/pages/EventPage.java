package org.districtappautomation.test.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class EventPage {
    WebDriver driver;

    @FindBy(linkText = "Events")
    WebElement eventsTab;

    @FindBy(xpath ="//button[@aria-label='This Weekend']")
    WebElement thisweekend;

    public EventPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void displayListOfEvents() throws InterruptedException {
        eventsTab.click();
        Thread.sleep(3000);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 800);");
        thisweekend.click();
        Assert.assertTrue(
                thisweekend.isDisplayed() && thisweekend.isEnabled(),
                "This Weekend button was not clicked or not active"
        );

        int count=1;
        List<WebElement> eventNames = driver.findElements(
                By.xpath("//a[contains(@href,'/events/')]/div//img")
        );

        Assert.assertTrue(
                eventNames.size() > 0,
                "No events are displayed in the console"
        );

        By eventsLocator = By.xpath("//a[contains(@href,'/events/')]/div//img");

        for (int i = 0; i < driver.findElements(eventsLocator).size(); i++) {
            try {
                WebElement event =
                        driver.findElements(eventsLocator).get(i);
                String eventName = event.getAttribute("alt");
                if (eventName != null && !eventName.trim().isEmpty()) {
                    System.out.println((i + 1) + ". " + eventName);
                }
            } catch (StaleElementReferenceException e) {
                WebElement retry =
                        driver.findElements(eventsLocator).get(i);
                String eventName = retry.getAttribute("alt");
                System.out.println((i + 1) + ". " + eventName);
            }
        }
    }
}