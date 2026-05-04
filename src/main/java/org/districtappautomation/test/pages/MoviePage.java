package org.districtappautomation.test.pages;

import org.districtappautomation.test.utility.ScreenshotUtil;
import org.districtappautomation.test.utility.WaitUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MoviePage {

    WebDriver driver;

    @FindBy(linkText = "Movies")
    WebElement movieIcon;

    @FindBy(xpath = "//button[@type='button' and .//span[normalize-space()='Filters']]")
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


    /* -------- LOCATORS -------- */

    @FindBy(xpath = "//button[@type='button' and .//span[normalize-space()='Filters']]")
    private WebElement filtersButton;

    @FindBy(xpath = "//span[normalize-space()='Genre']")
    private WebElement genreTab;

    @FindBy(xpath = "//span[normalize-space()='Language']")
    private WebElement languageTab;

    @FindBy(xpath = "//button[@aria-label='Apply Filters']")
    private WebElement applyFiltersButton;

    @FindBy(xpath = "//div[normalize-space()='Clear filters']")
    private WebElement clearFiltersButton;

    @FindBy(xpath = "//div[contains(@class,'dds-bg-surface-secondary')]//span")
    private List<WebElement> allFilterOptions;

    @FindBy(xpath = "//div[contains(@class,'dds-grid')]//a")
    private List<WebElement> ThisWeekMovieCards;


    @FindBy(xpath = "//div[contains(@class,'dds-grid')]/a")
    private List<WebElement> FilterMovieCards;



    public MoviePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickMovies() {
        movieIcon.click();
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


    /* -------- ACTIONS -------- */

    public void openFilters() {
        WaitUtils.waitForElementToBeClickable(driver, filterButton);
        filtersButton.click();
    }

    public void openGenreTab() {
        genreTab.click();
    }

    public void openLanguageTab() {
        languageTab.click();
    }

    public List<String> getAvailableLanguages() {

        List<String> languages = new ArrayList<>();

        for (WebElement lang : allFilterOptions) {
            String text = lang.getText().trim();
            if (!text.isEmpty()) {
                languages.add(text);
            }
        }
        return languages;
    }

    public void selectFilterOptions(String... options) {
        for (String optionText : options) {
            for (WebElement option : allFilterOptions) {
                if (option.getText().equalsIgnoreCase(optionText)) {
                    option.click();
                    break;
                }
            }
        }
    }

    public void applyFilters() {
        WaitUtils.waitForElementToBeClickable(driver, applyFiltersButton);
        applyFiltersButton.click();
    }

    public void clearAllFilters() {
        clearFiltersButton.click();
    }


    public boolean printDisplayeFilterMovieNames() {
        WaitUtils.waitForAllElementVisible(driver,FilterMovieCards);
        int size = FilterMovieCards.size();
        if (size == 0) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            try {
                String title = FilterMovieCards.get(i).getText().trim();
                if (!title.isEmpty()) {
                    System.out.println(title);
                }
            } catch (StaleElementReferenceException e) {
                PageFactory.initElements(driver, this);
                String title = FilterMovieCards.get(i).getText().trim();
                if (!title.isEmpty()) {
                    System.out.println(title);
                }
            }
        }
        return true;
    }



    public boolean areAllFiltersCleared() {

        for (WebElement option : allFilterOptions) {

            // check selection using aria-checked or class
            String ariaChecked = option.getAttribute("aria-checked");
            String classValue = option.getAttribute("class");

            if ("true".equalsIgnoreCase(ariaChecked)
                    || classValue.contains("active")
                    || classValue.contains("selected")) {
                return false; // some filter is still selected
            }
        }
        return true;
    }

}









