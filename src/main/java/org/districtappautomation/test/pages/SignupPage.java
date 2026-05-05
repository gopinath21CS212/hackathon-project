package org.districtappautomation.test.pages;

import org.districtappautomation.test.utility.WaitUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {

    WebDriver driver;

    @FindBy(xpath = "//div[contains(@class,'dds-rounded-full') and contains(@class,'dds-flex')]")
    private WebElement profileIcon;

    @FindBy(name = "mobileNumber")
    private WebElement phoneInput;

    @FindBy(xpath = "//button[text()='Continue']")
    private WebElement continueBtn;

    @FindBy(xpath = "//p[contains(text(),'enter a valid')]")
    private WebElement errorMessage;

    @FindBy(xpath = "//label[normalize-space()='Enter OTP']")
    private WebElement otpIndicator;

    @FindBy(xpath = "(//button[contains(@class,'dds-flex') and contains(@class,'dds-absolute')])[4]")
    private WebElement closeBtn;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openSignupModal() {
        WebElement icon = WaitUtils.waitForElementVisible(driver, profileIcon);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", icon);
    }

    public void enterNumberAndSubmit(String number) {
        WebElement input = WaitUtils.waitForElementVisible(driver, phoneInput);
        input.clear();
        input.sendKeys(number);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", continueBtn);
    }

    public String getErrorText() {
        return WaitUtils.waitForElementVisible(driver, errorMessage).getText();
    }

    public boolean isOtpScreenDisplayed() {
        try {
            WaitUtils.waitForElementVisible(driver, otpIndicator);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isVerificationFlowTriggered() {
        return isOtpScreenDisplayed();
    }

    public void closeModal() {
        try {
            if (closeBtn.isDisplayed()) {
                closeBtn.click();
            } else {
                driver.navigate().refresh();
            }
        } catch (Exception e) {
            driver.navigate().refresh();
        }
    }
}