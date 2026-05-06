package org.districtappautomation.test.pages;

import org.districtappautomation.test.utility.LoggerUtil;
import org.districtappautomation.test.utility.WaitUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

    public String displayListOfEvents() {
        LoggerUtil.info("TestCase_16 Started");
        eventsTab.click();

        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 800);");
        WaitUtils.waitForElementToBeClickable(driver,thisweekend);
        thisweekend.click();

        if(!(thisweekend.isDisplayed() && thisweekend.isEnabled())) return "This Weekend button was not clicked or not active";

        int count=1;
        List<WebElement> eventNames = driver.findElements(By.xpath("//a[contains(@href,'/events/')]/div//img"));

        if(!(eventNames.size()>0)) return "No events are displayed in the console";
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
        return "";
    }

    public String priceLowToHigh() {
        LoggerUtil.info("TestCase_19 Started");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        eventsTab.click();
        js.executeScript("window.scrollBy(0, 800);");

        WaitUtils.waitForElementToBeClickable(driver,filterButton);
        filterButton.click();

        WaitUtils.waitForElementToBeClickable(driver,filterClick);
        filterClick.click();
        WebElement lowToHighRadio = WaitUtils.waitPresenceOfElementLocated(driver, By.xpath("//span[@role='radio' and @aria-label='Price : Low to High']"));

        if(!lowToHighRadio.getAttribute("aria-checked").equals("true")){
            return "Price Low to High radio button is NOT selected";
        }
        WaitUtils.waitForElementToBeClickable(driver,applyFilter);
        applyFilter.click();

        LoggerUtil.info("TestCase_19 Execution Successful");
        return "";
    }

    public String checkboxValidation() {
        LoggerUtil.info("TestCase_18 Started");
        WaitUtils.waitForElementVisible(driver,eventsTab);
        eventsTab.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 1000);");
        WaitUtils.waitForElementToBeClickable(driver,thisweekend);
        thisweekend.click();

        if(!(thisweekend.isDisplayed() && thisweekend.isEnabled())){
            return "This Weekend button was not clicked or not active";
        }
        WaitUtils.waitForElementToBeClickable(driver,today);
        today.click();

        if(!(today.isDisplayed() && today.isEnabled())){
            return "Today button was not clicked or not active";
        }
        WaitUtils.waitForElementToBeClickable(driver,tomorrow);
        tomorrow.click();

        if(!(tomorrow.isDisplayed() && tomorrow.isEnabled())){
            return "Tomorrow button was not clicked or not active";
        }
        LoggerUtil.info("TestCase_18 Execution Successful");
        return "";
    }
}