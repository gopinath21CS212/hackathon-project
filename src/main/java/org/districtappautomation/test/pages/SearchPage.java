package org.districtappautomation.test.pages;

import org.districtappautomation.test.utility.WaitUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {

    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/search']")
    private WebElement homeSearchBar;

    @FindBy(xpath = "//div[contains(@class,'item-cards')]")
    private List<WebElement> searchResults;

    public void performSearch(String keyword) {
        WaitUtils.waitForElementToBeClickable(driver, homeSearchBar).click();
        driver.switchTo().activeElement().sendKeys(keyword, Keys.ENTER);
    }

    public int getResultsCount() {
        return searchResults.size();
    }
}