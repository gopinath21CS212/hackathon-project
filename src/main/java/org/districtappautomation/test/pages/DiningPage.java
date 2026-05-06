package org.districtappautomation.test.pages;

import org.districtappautomation.test.utility.LoggerUtil;
import org.districtappautomation.test.utility.WaitUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

    @FindBy(xpath = "//span[text()=\"Movies\"]")
    WebElement diningMoviesTab;

    @FindBy(xpath = "//div[contains(@class,'dds-grid')]/div[contains(@class,'dds-flex-none')]")
    List<WebElement> trendingMoviesList;

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

    public boolean displayTrendingMoviesList() throws InterruptedException {
        Thread.sleep(2000);
        if(getTrendingMoviesList().isEmpty()){
            return false;
        }
        else{
            for(WebElement trendingMovies : trendingMoviesList){
                LoggerUtil.info(trendingMovies.getText());
            }
        }
        return true;
    }

    public void openDiningTabSearchBox(){
        diningTab.click();
        WaitUtils.waitForElementToBeClickable(driver,searchBox);
        searchBox.click();
    }

    public boolean selectRestaurantAndPrintDetails() {
        openDiningTabSearchBox();
        WaitUtils.waitForElementToBeClickable(driver, Restaurant).click();

        if(!driver.getCurrentUrl().contains("/dining")) return false;
        WaitUtils.waitForElementVisible(driver, restaurantName);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", restaurantName);

        LoggerUtil.info("======= Restaurant Details =======");
        LoggerUtil.info("Name : " + restaurantName.getText());
        LoggerUtil.info("Address : " + address.getText());
        LoggerUtil.info("Ratings : " + ratingSection.getText());
        LoggerUtil.info("Contact : " + contactNumber.getText());
        LoggerUtil.info("=================================");
        return true;
    }

    public boolean printAboutRestaurantDetails() {
        openDiningTabSearchBox();
        WaitUtils.waitForElementToBeClickable(driver, Restaurant).click();

        if(!driver.getCurrentUrl().contains("/dining")) return false;
        WaitUtils.waitForElementVisible(driver, aboutHeader);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", aboutHeader);

        LoggerUtil.info("======= About the Restaurant =======");
        LoggerUtil.info("Cost         : " + cost.getText());
        LoggerUtil.info("Cuisines     : " + cuisines.getText());
        LoggerUtil.info("Number of Available Facilities : " + facilities.size());

        for (WebElement facility : facilities) {
            LoggerUtil.info(" - " + facility.getText());
        }

        LoggerUtil.info("===================================");
        return true;
    }
}
