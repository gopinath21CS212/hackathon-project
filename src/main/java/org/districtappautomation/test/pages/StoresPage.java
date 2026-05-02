package org.districtappautomation.test.pages;

import org.districtappautomation.test.utility.WaitUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.util.List;

public class StoresPage {

    WebDriver driver;
    @FindBy(xpath = "(//section[contains(.,'Shop by Category')]//a)[3]")
    WebElement thirdCategory;
    @FindBy(xpath = "(//a[contains(@href,'/stores/')])[6]")
    WebElement fourthStore;
    @FindBy(xpath ="//a[text()=\"Stores\"]")
    WebElement storesButton;
    @FindBy(xpath = "//h3")
    WebElement storeName;
    @FindBy(xpath = "//h3/following::span[3]")
    WebElement storeAddress;
    @FindBy(xpath = "//span[normalize-space()='Top items in store']")
    WebElement topItemsHeader;
    @FindBy(xpath = "//span[normalize-space()='Top items in store']/following-sibling::div")
    List<WebElement> topItems;
    @FindBy(xpath ="//a[contains(@href,'footwear-stores')]")
    WebElement footwearButton;
    @FindBy(xpath = "//img/following-sibling::div/h5")
    List<WebElement> storesNameList;

    public StoresPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToStoresPage() {
        WaitUtils.waitForElementToBeClickable(driver,storesButton);
        storesButton.click();
    }

    public void navigateToFootwearPage() {
        WaitUtils.waitForElementToBeClickable(driver,footwearButton);
        footwearButton.click();
    }

    public List<WebElement> getStoresNameList() {
        return storesNameList;
    }
    public void displayFootwearBrandsInYourCity(){
        WaitUtils.waitForElementToBeClickable(driver,storesNameList.get(0));
        Assert.assertFalse(getStoresNameList().isEmpty(), "Footwear list is empty!");
        System.out.println("Footwear brands in your city: ");
        for(WebElement storesName:storesNameList){
            System.out.println(storesName.getText());
        }
    }

    public void selectThirdCategory() {
        WaitUtils.waitForElementToBeClickable(driver, thirdCategory).click();
    }

    public void selectFourthStore() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", fourthStore);
        WaitUtils.waitForElementToBeClickable(driver, fourthStore).click();
    }

    public void printStoreDetailsAndTopItems() {

        WaitUtils.waitForElementVisible(driver, storeName);
        System.out.println("======= Store Details =======");
        System.out.println("Store Name    : " + storeName.getText());
        System.out.println("Store Address : " + storeAddress.getText());
        System.out.println("=============================");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", topItemsHeader);

        WaitUtils.waitForElementVisible(driver, topItemsHeader);

        System.out.println("======= Top Items in Store =======");

        for (WebElement item : topItems) {
            System.out.println(" - " + item.getText());
        }
        System.out.println("=================================");
    }
}
