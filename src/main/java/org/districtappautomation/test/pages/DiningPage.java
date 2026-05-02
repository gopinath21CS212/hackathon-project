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
}
