package org.districtappautomation.test.pages;

import org.districtappautomation.test.utility.ScreenshotUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class EventPage {
    WebDriver driver;

    @FindBy(linkText = "Events")
    WebElement eventsTab;

    @FindBy(xpath = "//button[.//span[normalize-space()='Today']]")
    WebElement today;

    @FindBy(xpath = "//button[@aria-label='Tomorrow']")
    WebElement tomorrow;

    @FindBy(xpath ="//button[@aria-label='This Weekend']")
    WebElement thisweekend;

    @FindBy(xpath = "//button[.//span[normalize-space()='Filters']]")
    WebElement filterButton;

    @FindBy(xpath = "//label[contains(@for,'Low to High')]")
    WebElement filterClick;

    @FindBy(xpath = "//span[normalize-space(text())='Apply Filters']")
    WebElement applyFilter;

    public EventPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void displayListOfEvents() throws InterruptedException {
        eventsTab.click();
        Thread.sleep(3000);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 800);");
        Thread.sleep(2000);
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
    public void priceLowToHigh() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        eventsTab.click();
        wait.until(ExpectedConditions.elementToBeClickable(filterButton));
        js.executeScript("window.scrollBy(0, 800);");
        filterButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(filterClick));
        filterClick.click();
        ScreenshotUtil.takeScreenshot(driver);
        WebElement lowToHighRadio = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//span[@role='radio' and @aria-label='Price : Low to High']")
        ));

        Assert.assertEquals(
                lowToHighRadio.getAttribute("aria-checked"),
                "true",
                "Price Low to High radio button is NOT selected"
        );

        wait.until(ExpectedConditions.elementToBeClickable(applyFilter));
        applyFilter.click();
    }
    public void checkboxValidation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        eventsTab.click();
        wait.until(ExpectedConditions.elementToBeClickable(thisweekend));
        js.executeScript("window.scrollBy(0, 1000);");
        thisweekend.click();
        ScreenshotUtil.takeScreenshot(driver);
        Assert.assertTrue(
                thisweekend.isDisplayed() && thisweekend.isEnabled(),
                "This Weekend button was not clicked or not active"
        );

        wait.until(ExpectedConditions.elementToBeClickable(today));
        today.click();
        ScreenshotUtil.takeScreenshot(driver);
        Assert.assertTrue(
                today.isDisplayed() && today.isEnabled(),
                "Today button was not clicked or not active"
        );

        wait.until(ExpectedConditions.elementToBeClickable(tomorrow));
        tomorrow.click();
        ScreenshotUtil.takeScreenshot(driver);
        Assert.assertTrue(
                tomorrow.isDisplayed() && tomorrow.isEnabled(),
                "Tomorrow button was not clicked or not active"
        );
    }

}