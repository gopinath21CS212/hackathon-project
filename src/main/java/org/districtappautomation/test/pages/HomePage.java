package org.districtappautomation.test.pages;

import org.districtappautomation.test.utility.LoggerUtil;
import org.districtappautomation.test.utility.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

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

    @FindBy(xpath = "//span[text()=\"Artists in your District\"]")
    WebElement artistHeader;

    @FindBy(xpath ="//a/div/div/h5")
    List<WebElement> artistList;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToEvents() {
        eventsTab.click();
        WaitUtils.waitForUrlContains(driver, "events");
    }

    public boolean changeLocationAndValidate(String location1) throws InterruptedException {
        Thread.sleep(4000);
        WaitUtils.waitForElementToBeClickable(driver, locationSelector).click();

        WebElement searchInput = WaitUtils.waitForElementVisible(driver, searchInputBy);
        searchInput.clear();
        searchInput.sendKeys(location1);

        WebElement firstResult = WaitUtils.waitForElementToBeClickable(driver, firstResultBy);
        firstResult.click();

        WebElement selectedLocation1 = WaitUtils.waitForElementVisible(driver, currentLocation);
        return validateLocationSelector(location1, selectedLocation1);
    }

    public boolean validateLocationSelector(String ExpectredLocation, WebElement currentLocation) throws InterruptedException {
        Thread.sleep(   3000);
        return ExpectredLocation.equals(currentLocation.getText());
    }

    public boolean validatePage(String expectedPage){
        return driver.getCurrentUrl().contains(expectedPage);
    }

    public boolean navigateToDiningandValidate(){
        WaitUtils.waitForElementToBeClickable(driver,dinningTab);
        dinningTab.click();
        WaitUtils.waitForUrlContains(driver, "dining");
        return validatePage("dining");
    }

    public boolean navigateToMoviesandValidate(){
        WaitUtils.waitForElementToBeClickable(driver,moviesTab);
        moviesTab.click();
        WaitUtils.waitForUrlContains(driver, "movies");
        return validatePage("movies");
    }

    public boolean navigateToEventandValidate(){
        WaitUtils.waitForElementToBeClickable(driver,eventsTab);
        eventsTab.click();
        WaitUtils.waitForUrlContains(driver, "events");
        return validatePage("events");
    }

    public Boolean navigateToIPLandValidate(){
        WaitUtils.waitForElementToBeClickable(driver,iPLTab);
        iPLTab.click();
        WaitUtils.waitForUrlContains(driver, "ipl-ticket-booking");
        return validatePage("ipl-ticket-booking");
    }

    public boolean navigateToStoresandValidate(){
        WaitUtils.waitForElementToBeClickable(driver,storesTab);
        storesTab.click();
        WaitUtils.waitForUrlContains(driver, "stores");
        return validatePage("stores");
    }

    public boolean navigateToActivitiesandValidate(){
        WaitUtils.waitForElementToBeClickable(driver,activitiesTab);
        activitiesTab.click();
        WaitUtils.waitForUrlContains(driver, "activities");
        return validatePage("activities");
    }

    public void printArtistInYourCity(){
        WaitUtils.waitForElementVisible(driver,artistHeader);
        LoggerUtil.info("Artist List In Your City: ");
        for(WebElement artist : artistList){
            LoggerUtil.info(artist.getText());
        }
    }

}