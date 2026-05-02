package org.districtappautomation.test.pages;

import org.districtappautomation.test.utility.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Objects;


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

    @FindBy(xpath = "//a[text()=\"Dining\"]")
    WebElement dinningTab;

    @FindBy(xpath = "//a[text()=\"Movies\"]")
    WebElement moviesTab;

    @FindBy(xpath = "//a[text()=\"Activities\"]")
    WebElement activitiesTab;

    @FindBy(xpath = "//a[text()=\"Stores\"]")
    WebElement storesTab;

    @FindBy(xpath = "//a[text()=\"IPL\"]")
    WebElement iPLTab;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void navigateToEvents() {
        eventsTab.click();
        WaitUtils.waitForUrlContains(driver, "events");
    }

    public void changeLocationAndValidate(String location1) throws InterruptedException {
        WaitUtils.waitForElementToBeClickable(driver, locationSelector).click();
        WebElement searchInput = WaitUtils.waitForElementVisible(driver, searchInputBy);
        searchInput.clear();
        searchInput.sendKeys(location1);
        WebElement firstResult = WaitUtils.waitForElementToBeClickable(driver, firstResultBy);
        firstResult.click();
        WebElement selectedLocation1 =
                WaitUtils.waitForElementVisible(driver, currentLocation);
        validateLocationSelector(location1, selectedLocation1);
    }


    public void validateLocationSelector(String ExpectredLocation, WebElement currentLocation) throws InterruptedException {
        Thread.sleep(1500);
        Assert.assertEquals(ExpectredLocation, currentLocation.getText(),"Location Selector is Not Working Properly");
    }

    public void validatePage(String expectedPage){
        Assert.assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains(expectedPage),"Event Page Not Found");
    }

    public void navigateToDiningandValidate(){
        WaitUtils.waitForElementToBeClickable(driver,dinningTab);
        dinningTab.click();
        WaitUtils.waitForUrlContains(driver, "dining");
        validatePage("dining");
    }

    public void navigateToMoviesandValidate(){
        WaitUtils.waitForElementToBeClickable(driver,moviesTab);
        moviesTab.click();
        WaitUtils.waitForUrlContains(driver, "movies");
        validatePage("movies");
    }

    public void navigateToEventandValidate(){
        WaitUtils.waitForElementToBeClickable(driver,eventsTab);
        eventsTab.click();
        WaitUtils.waitForUrlContains(driver, "events");
        validatePage("events");
    }

    public void navigateToIPLandValidate(){
        WaitUtils.waitForElementToBeClickable(driver,iPLTab);
        iPLTab.click();
        WaitUtils.waitForUrlContains(driver, "ipl-ticket-booking");
        validatePage("ipl-ticket-booking");
    }

    public void navigateToStoresandValidate(){
        WaitUtils.waitForElementToBeClickable(driver,storesTab);
        storesTab.click();
        WaitUtils.waitForUrlContains(driver, "stores");
        validatePage("stores");
    }

    public void navigateToActivitiesandValidate(){
        WaitUtils.waitForElementToBeClickable(driver,activitiesTab);
        activitiesTab.click();
        WaitUtils.waitForUrlContains(driver, "activities");
        validatePage("activities");
    }

}

