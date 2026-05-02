package org.districtappautomation.test.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private static WebDriverWait getWait(WebDriver driver) {
        return new WebDriverWait(
                driver,
                Duration.ofSeconds(ConfigReader.getExplicitTimeout())
        );
    }

    public static WebElement waitForElementToBeClickable(
            WebDriver driver, WebElement element) {
        return getWait(driver)
                .until(ExpectedConditions.elementToBeClickable(element));
    }


    public static WebElement waitForElementVisible(
            WebDriver driver, WebElement element) {
        return getWait(driver)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static boolean waitForUrlContains(WebDriver driver, String partialUrl) {
        return getWait(driver)
                .until(ExpectedConditions.urlContains(partialUrl));
    }

}