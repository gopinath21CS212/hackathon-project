package org.districtappautomation.test.pages;

import org.districtappautomation.test.utility.LoggerUtil;
import org.districtappautomation.test.utility.ScreenshotUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
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

    public void displayListOfEvents(SoftAssert softAssert) throws InterruptedException {
        LoggerUtil.info("TestCase_16 Started");
        eventsTab.click();
        Thread.sleep(3000);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 800);");
        Thread.sleep(2000);
        thisweekend.click();
        softAssert.assertTrue(thisweekend.isDisplayed() && thisweekend.isEnabled(), "This Weekend button was not clicked or not active");
        int count=1;
        List<WebElement> eventNames = driver.findElements(By.xpath("//a[contains(@href,'/events/')]/div//img"));
        softAssert.assertTrue(eventNames.size() > 0, "No events are displayed in the console");
        By eventsLocator = By.xpath("//a[contains(@href,'/events/')]/div//img");
        for (int i = 0; i < driver.findElements(eventsLocator).size(); i++) {
            try {
                WebElement event = driver.findElements(eventsLocator).get(i);
                String eventName = event.getAttribute("alt");
                if (eventName != null && !eventName.trim().isEmpty()) {
                    LoggerUtil.info((i + 1) + ". " + eventName);
                }
            } catch (StaleElementReferenceException e) {
                WebElement retry = driver.findElements(eventsLocator).get(i);
                String eventName = retry.getAttribute("alt");
                LoggerUtil.info((i + 1) + ". " + eventName);
            }
        }
        LoggerUtil.info("TestCase_16 Execution Successful");
    }

    public void priceLowToHigh(SoftAssert softAssert) {
        LoggerUtil.info("TestCase_19 Started");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        eventsTab.click();
        js.executeScript("window.scrollBy(0, 800);");
        wait.until(ExpectedConditions.elementToBeClickable(filterButton));
        filterButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(filterClick));
        filterClick.click();
        ScreenshotUtil.takeScreenshot(driver);
        WebElement lowToHighRadio = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@role='radio' and @aria-label='Price : Low to High']")));
        softAssert.assertEquals(lowToHighRadio.getAttribute("aria-checked"), "true", "Price Low to High radio button is NOT selected");
        wait.until(ExpectedConditions.elementToBeClickable(applyFilter));
        applyFilter.click();
        LoggerUtil.info("TestCase_19 Execution Successful");
    }

    public void checkboxValidation(SoftAssert softAssert) {
        LoggerUtil.info("TestCase_18 Started");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        eventsTab.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 1000);");
        wait.until(ExpectedConditions.elementToBeClickable(thisweekend));
        thisweekend.click();
        ScreenshotUtil.takeScreenshot(driver);
        softAssert.assertTrue(thisweekend.isDisplayed() && thisweekend.isEnabled(), "This Weekend button was not clicked or not active");
        wait.until(ExpectedConditions.elementToBeClickable(today));
        today.click();
        ScreenshotUtil.takeScreenshot(driver);
        softAssert.assertTrue(today.isDisplayed() && today.isEnabled(), "Today button was not clicked or not active");
        wait.until(ExpectedConditions.elementToBeClickable(tomorrow));
        tomorrow.click();
        ScreenshotUtil.takeScreenshot(driver);
        softAssert.assertTrue(tomorrow.isDisplayed() && tomorrow.isEnabled(), "Tomorrow button was not clicked or not active");
        LoggerUtil.info("TestCase_18 Execution Successful");
    }
}