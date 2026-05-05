package org.districtappautomation.test.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class IPLPage {

    WebDriver driver;
    WebDriverWait wait;

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
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToIplPage() {
        wait.until(ExpectedConditions.elementToBeClickable(iplTab)).click();
    }

    public void printAvailableTickets() {

        wait.until(ExpectedConditions.visibilityOf(ticketsOnSaleHeader));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", ticketsOnSaleHeader);

        wait.until(ExpectedConditions.visibilityOfAllElements(availableTicketMatches));

        System.out.println("======= Available Tickets =======");
        for (WebElement match : availableTicketMatches) {
            System.out.println(
                    match.getText()
                            .replace("Sale is live", "")
                            .replace("Book tickets", "")
                            .trim()
            );
            System.out.println("--------------------------------");
        }
        System.out.println("================================");
    }

    public void printUpcomingMatches() {

        wait.until(ExpectedConditions.visibilityOf(upcomingHeader));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", upcomingHeader);

        wait.until(ExpectedConditions.visibilityOfAllElements(upcomingMatches));

        System.out.println("======= Upcoming Matches =======");
        for (WebElement match : upcomingMatches) {
            System.out.println(
                    match.getText()
                            .replace("Coming soon", "")
                            .trim()
            );
            System.out.println("--------------------------------");
        }
        System.out.println("===============================");
    }
}