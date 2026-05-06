package org.districtappautomation.test.pages;

import org.districtappautomation.test.utility.LoggerUtil;
import org.districtappautomation.test.utility.ScreenshotUtil;
import org.districtappautomation.test.utility.WaitUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MoviePage {

    WebDriver driver;

    @FindBy(linkText = "Movies")
    WebElement movieIcon;

    @FindBy(xpath = "//button[@type='button' and .//span[normalize-space()='Filters']]")
    WebElement filterButton;

    @FindBy(xpath = "//span[normalize-space()='Animation']/ancestor::div[contains(@class,'checkbox-container')]")
    WebElement animationContainer;

    @FindBy(xpath = "//span[normalize-space()='Animation']/preceding-sibling::input")
    WebElement animationCheckbox;

    @FindBy(xpath = "//button[@aria-label='Apply Filters']")
    WebElement applyFilter;

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

    @FindBy(xpath = "//div[contains(@class,'dds-grid')]/a")
    private List<WebElement> FilterMovieCards;

    public MoviePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickMovies() {
        movieIcon.click();
    }

    public boolean display3dGenre() throws InterruptedException {
        LoggerUtil.info("TestCase_17 Started");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        movieIcon.click();
        WaitUtils.waitForElementToBeClickable(driver,filterButton);

        js.executeScript("window.scrollBy(0, 800);");
        filterButton.click();

        WaitUtils.waitForElementToBeClickable(driver,animationContainer);
        animationContainer.click();
        if(!animationCheckbox.isSelected()) return false;

        WaitUtils.waitForElementToBeClickable(driver,applyFilter);
        applyFilter.click();

        LoggerUtil.info("TestCase_17 Execution successful");
        return true;
    }

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
        By locator = By.xpath("//div[contains(@class,'dds-grid')]/a");

        for (int attempt = 0; attempt < 2; attempt++) {
            try {
                List<WebElement> cards = driver.findElements(locator);
                if (cards.isEmpty()) return false;
                for (WebElement card : cards) {
                    LoggerUtil.info(card.getText());
                }
                return true;
            } catch (StaleElementReferenceException e) {
                LoggerUtil.warn("Retrying due to DOM refresh...");
            }
        }
        return false;
    }

    public boolean areAllFiltersCleared() {
        for (WebElement option : allFilterOptions) {
            String ariaChecked = option.getAttribute("aria-checked");
            String classValue = option.getAttribute("class");
            if ("true".equalsIgnoreCase(ariaChecked) || classValue.contains("active") || classValue.contains("selected")) {
                return false;
            }
        }
        return true;
    }
}