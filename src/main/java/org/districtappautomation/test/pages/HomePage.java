package org.districtappautomation.test.pages;

import org.districtappautomation.test.utility.ConfigReader;
import org.districtappautomation.test.utility.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage {

    WebDriver driver;

    @FindBy(linkText = "Events")
    WebElement eventsTab;

    @FindBy(xpath = "//div[contains(@class,'dds-flex-none')]/button[@type=\"button\"]")
    WebElement locationSelector;

    @FindBy(xpath = "//button[@type=\"button\"]/div/div[contains(@class,'dds-items-baseline')]/span")
    WebElement currentLocation;

    @FindBy(xpath = "//input[@placeholder='Search city, area or locality']")
    WebElement searchInputBy;

    @FindBy(xpath ="//div[contains(@class,'dds-no-scrollbar')]/div/button")
    WebElement firstResultBy;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void navigateToEvents() {
        eventsTab.click();
    }

//    public void changeLocationAndValidate(String location1, String location2) throws InterruptedException {
//
//        // Open location selector
//        WaitUtils.waitForElementToBeClickable(driver, locationSelector).click();
//
//        By searchInputBy = By.xpath("//input[@placeholder='Search city, area or locality']");
//        By firstResultBy = By.xpath("//div[contains(@class,'dds-no-scrollbar')]/div/button");
//
//        // ---------- First location ----------
//        WebElement searchInput = WaitUtils.waitForElementVisible(driver, searchInputBy);
//        searchInput.clear();
//        searchInput.sendKeys(location1);
//        Thread.sleep(3000);
//        WebElement firstResult = WaitUtils.waitForElementToBeClickable(driver, firstResultBy);
//        firstResult.click();
//        Thread.sleep(2000);
//        WebElement selectedLocation1 =
//                WaitUtils.waitForElementVisible(driver, currentLocation);
//
//        validateLocationSelector(location1, selectedLocation1);
//
//        // ---------- Second location ----------
//        WaitUtils.waitForElementToBeClickable(driver, locationSelector).click();
//
//        WebElement searchInput2 = WaitUtils.waitForElementVisible(driver, searchInputBy);
//        searchInput2.clear();
//        searchInput2.sendKeys(location2);
//
//        WebElement secondResult =
//                WaitUtils.waitForElementToBeClickable(driver, firstResultBy);
//        secondResult.click();
//
//        WebElement selectedLocation2 =
//                WaitUtils.waitForElementVisible(driver, currentLocation);
//
//        validateLocationSelector(location2, selectedLocation2);
//    }


    public void validateLocationSelector(String ExpectredLocation, WebElement currentLocation) {
        Assert.assertEquals(ExpectredLocation, currentLocation.getText(),"Location Selector is Not Working Properly");
    }

    public void validateEventPage(){
        Assert.assertTrue(driver.getCurrentUrl().contains("events"),"Event Page Not Found");
    }

}

