package org.districtappautomation.test.pages;

import org.districtappautomation.test.utility.LoggerUtil;
import org.districtappautomation.test.utility.WaitUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class IPLPage {

    WebDriver driver;

    @FindBy(xpath = "//a[normalize-space()='IPL']")
    WebElement iplTab;

    @FindBy(xpath = "//h1[normalize-space()='Tickets on sale']")
    WebElement ticketsOnSaleHeader;

    @FindBy(xpath = "//h1[normalize-space()='Upcoming']")
    WebElement upcomingHeader;

    @FindBy(xpath = "//h1[normalize-space()='Tickets on sale']/following-sibling::div//div[contains(@class,'css-k20qch')]")
    List<WebElement> availableTicketMatches;

    @FindBy(xpath = "//h1[normalize-space()='Upcoming']/following-sibling::div//div[contains(@class,'css-k20qch')]")
    List<WebElement> upcomingMatches;

    public IPLPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToIplPage() {
        WaitUtils.waitForElementToBeClickable(driver,iplTab).click();
        WaitUtils.waitForElementVisible(driver,ticketsOnSaleHeader);
    }

    public void printAvailableTickets() {
        WaitUtils.waitForElementToBeClickable(driver,ticketsOnSaleHeader);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ticketsOnSaleHeader);

        WaitUtils.waitForAllElementVisible(driver,availableTicketMatches);
        LoggerUtil.info("======= Available Tickets =======");

        for (WebElement match : availableTicketMatches) {
            LoggerUtil.info(
                    match.getText()
                            .replace("Sale is live", "")
                            .replace("Book tickets", "")
                            .trim()
            );
            LoggerUtil.info("--------------------------------");
        }
        LoggerUtil.info("================================");
    }

    public void printUpcomingMatches() {
        WaitUtils.waitForElementToBeClickable(driver,upcomingHeader);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", upcomingHeader);
        WaitUtils.waitForAllElementVisible(driver,upcomingMatches);

        LoggerUtil.info("======= Upcoming Matches =======");
        for (WebElement match : upcomingMatches) {
            LoggerUtil.info(
                    match.getText()
                            .replace("Coming soon", "")
                            .trim());
            LoggerUtil.info("--------------------------------");
        }
        LoggerUtil.info("===============================");
    }
}