package org.districtappautomation.test.pages;

import org.districtappautomation.test.utility.WaitUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class DiningPage {
    WebDriver driver;
    @FindBy(linkText = "Dining")
    WebElement diningTab;
    @FindBy(xpath = "//img[contains(@alt,'Dining Large Image')]")
    WebElement searchBox;
    @FindBy(xpath = "(//div[contains(@class,'dds-grid')]//div[contains(@class,'dds-flex-none')])[1]")
    WebElement Restaurant;
    @FindBy(xpath = "//h1")
    WebElement restaurantName;
    @FindBy(xpath = "(//address/span)[2]")
    WebElement address;
    @FindBy(xpath = "//*[local-name()='svg']/preceding-sibling::span")
    WebElement ratingSection;
    @FindBy(xpath = "//a[starts-with(@href,'tel:')]//span")
    WebElement contactNumber;
    @FindBy(xpath = "//h2[text()='About the restaurant']")
    WebElement aboutHeader;
    @FindBy(xpath = "//h2[@title='Cost']/following-sibling::div//p")
    WebElement cost;
    @FindBy(xpath = "//section[@aria-labelledby='cuisines-heading']//p")
    WebElement cuisines;
    @FindBy(xpath = "//table//tbody//td//div/span[2]")
    List<WebElement> facilities;
    @FindBy(xpath = "//h2[text()='Book a table']")
    WebElement bookTableHeader;
    @FindBy(xpath = "//label[text()='Date']/following-sibling::div//button")
    WebElement dateDropdown;
    @FindBy(xpath = "(//div[@role='menuitem']//div[contains(@class,'truncate')])[3]")
    WebElement selectedDate;
    @FindBy(xpath = "//label[text()='Guests']/following-sibling::div//button")
    WebElement guestsDropdown;
    @FindBy(xpath = "//div[@role='menuitem']//div[normalize-space()='2 guests']")
    WebElement selectedGuest;
    @FindBy(xpath = "//button[normalize-space()='Book a table']")
    WebElement bookTableBtn;
    @FindBy(xpath = "//span[normalize-space()='Dinner']/ancestor::div[@role='button']")
    WebElement dinnerSlot;
    @FindBy(xpath = "(//div[@role='button']//span[contains(text(),'AM') or contains(text(),'PM')])[4]/ancestor::div[@role='button']")
    WebElement secondTimeSlot;
    @FindBy(xpath = "//input[@type='radio']")
    WebElement regularReservation;
    @FindBy(xpath = "//button[normalize-space()='Proceed to book']")
    WebElement proceedButton;

    @FindBy(xpath = "//span[text()=\"Movies\"]")
    WebElement diningMoviesTab;

    @FindBy(xpath = "//div[contains(@class,'dds-grid')]/div[contains(@class,'dds-flex-none')]")
    List<WebElement> trendingMoviesList;

    @FindBy(xpath = "//div[contains(@class,'dds-grid')]")
    WebElement trendingMoviesListContainerElement;

    public DiningPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToDiningMovieTab(){
        diningMoviesTab.click();
    }

    public List<WebElement> getTrendingMoviesList() {
        return trendingMoviesList;
    }

    public void displayTrendingMoviesList() throws InterruptedException {
        Thread.sleep(20000);
        Assert.assertFalse(getTrendingMoviesList().isEmpty(), "Trending movies list is empty!");
        for(WebElement trendingMovies : trendingMoviesList){
            System.out.println(trendingMovies.getText());
        }
    }
    public void openDiningTabSearchBox(){
        diningTab.click();
        WaitUtils.waitForElementToBeClickable(driver,searchBox);
        searchBox.click();
    }

    public void selectRestaurantAndPrintDetails() {
        openDiningTabSearchBox();
        WaitUtils.waitForElementToBeClickable(driver, Restaurant).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/dining"), "Restaurant page not opened");
        WaitUtils.waitForElementVisible(driver, restaurantName);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", restaurantName);
        System.out.println("======= Restaurant Details =======");
        System.out.println("Name : " + restaurantName.getText());
        System.out.println("Address : " + address.getText());
        System.out.println("Ratings : " + ratingSection.getText());
        System.out.println("Contact : " + contactNumber.getText());
        System.out.println("=================================");
    }
    public void printAboutRestaurantDetails() {
        openDiningTabSearchBox();
        WaitUtils.waitForElementToBeClickable(driver, Restaurant).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/dining"), "Restaurant page not opened");
        WaitUtils.waitForElementVisible(driver, aboutHeader);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", aboutHeader);
        System.out.println("======= About the Restaurant =======");
        System.out.println("Cost         : " + cost.getText());
        System.out.println("Cuisines     : " + cuisines.getText());
        System.out.println("Number of Available Facilities : " + facilities.size());
        for (WebElement facility : facilities) {
            System.out.println(" - " + facility.getText());
        }
        System.out.println("===================================");
    }
    public void bookTableAndPrintSelection() throws InterruptedException {
        openDiningTabSearchBox();
        WaitUtils.waitForElementToBeClickable(driver, Restaurant).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/dining"), "Restaurant page not opened");
        WaitUtils.waitForElementVisible(driver, bookTableHeader);
        WaitUtils.waitForElementToBeClickable(driver, dateDropdown).click();
        Thread.sleep(2000);
        String dateSelectedText = selectedDate.getText();
        WaitUtils.waitForElementToBeClickable(driver, selectedDate).click();
        WaitUtils.waitForElementToBeClickable(driver, guestsDropdown).click();
        String guestsSelectedText = selectedGuest.getText();
        WaitUtils.waitForElementToBeClickable(driver, selectedGuest).click();
        WaitUtils.waitForElementToBeClickable(driver, bookTableBtn).click();
        System.out.println("======= Booking Date & Guests Details =======");
        System.out.println("Date Selected   : " + dateSelectedText);
        System.out.println("Guests Selected : " + guestsSelectedText);
        System.out.println("================================");
    }

    public void selectSlotTimeAndProceed() throws InterruptedException {
        bookTableAndPrintSelection();
        WaitUtils.waitForElementToBeClickable(driver, dinnerSlot).click();
        String slotSelected = dinnerSlot.getText();
        String timeSelected = secondTimeSlot.getText();
        WaitUtils.waitForElementToBeClickable(driver, secondTimeSlot).click();
        WaitUtils.waitForElementToBeClickable(driver, regularReservation).click();
        WaitUtils.waitForElementToBeClickable(driver, proceedButton).click();
        System.out.println("======= Slot & Timing Details =======");
        System.out.println("Meal Slot Selected : " + slotSelected);
        System.out.println("Time Selected      : " + timeSelected);
        System.out.println("====================================");
    }
}
