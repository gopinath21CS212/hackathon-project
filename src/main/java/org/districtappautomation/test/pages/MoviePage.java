package org.districtappautomation.test.pages;

import org.districtappautomation.test.utility.ScreenshotUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class MoviePage {

    WebDriver driver;

    @FindBy(linkText = "Movies")
    WebElement movieIcon;

    @FindBy(xpath = "//button[.//span[normalize-space()='Filters']]")
    WebElement filterButton;

    // Container (for clicking)
    @FindBy(xpath = "//span[normalize-space()='Animation']/ancestor::div[contains(@class,'checkbox-container')]")
    WebElement animationContainer;

    @FindBy(xpath = "//span[normalize-space()='Animation']/preceding-sibling::input")
    WebElement animationCheckbox;

    @FindBy(xpath = "//button[@aria-label='Apply Filters']")
    WebElement applyFilter;

    @FindBy(xpath = "//button[.//span[normalize-space()='3D']]")
    WebElement threeD;

    public MoviePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void display3dGenre() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        movieIcon.click();
        wait.until(ExpectedConditions.elementToBeClickable(filterButton));
        js.executeScript("window.scrollBy(0, 800);");
        filterButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(animationContainer));
        animationContainer.click();
        wait.until(ExpectedConditions.elementToBeSelected(animationCheckbox));
        ScreenshotUtil.takeScreenshot(driver);
        Assert.assertTrue(
                animationCheckbox.isSelected(),
                "Animation checkbox is NOT selected"
        );

        wait.until(ExpectedConditions.elementToBeClickable(applyFilter));
        applyFilter.click();
        wait.until(ExpectedConditions.elementToBeClickable(threeD));
        threeD.click();
        ScreenshotUtil.takeScreenshot(driver);
    }

}