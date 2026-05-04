package org.districtappautomation.test.pages;

import org.districtappautomation.test.utility.WaitUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MusicEventsPage {

    private WebDriver driver;

    public MusicEventsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(@href,'/events')]")
    private WebElement eventsTab;

    @FindBy(xpath = "//a[contains(@href,'music-in-')]")
    private WebElement musicCategory;

    @FindBy(xpath = "//div[contains(@class,'item-cards')]")
    private List<WebElement> musicEvents;

    public void navigateToMusicEvents() {
        WaitUtils.waitForElementToBeClickable(driver, eventsTab).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");
        WaitUtils.waitForElementToBeClickable(driver, musicCategory).click();
    }
    public int getDisplayedEventsCount() {
        return musicEvents.size();
    }
}