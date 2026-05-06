package org.districtappautomation.test.pages;

import org.districtappautomation.test.utility.LoggerUtil;
import org.districtappautomation.test.utility.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

    @FindBy(xpath = "//span[normalize-space()='Top items in store']/following-sibling::div")
    List<WebElement> topItems;

    @FindBy(xpath ="//a[contains(@href,'footwear-stores')]")
    WebElement footwearButton;

    @FindBy(xpath = "//img/following-sibling::div/h5")
    List<WebElement> storesNameList;

    @FindBy(xpath = "//a[contains(@href,'home-furniture-stores')]")
    WebElement homeFurnitureCategory;

    @FindBy(xpath = "//h5")
    List<WebElement> storeNames;

    public StoresPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToStoresPage() {
        WaitUtils.waitForElementToBeClickable(driver,storesButton);
        storesButton.click();
        WaitUtils.waitForElementToBeClickable(driver, thirdCategory);
    }

    public void navigateToFootwearPage() {
        WaitUtils.waitForElementToBeClickable(driver,footwearButton);
        footwearButton.click();
    }

    public List<WebElement> getStoresNameList() {
        return storesNameList;
    }

    public boolean displayFootwearBrandsInYourCity(){
        WaitUtils.waitForElementToBeClickable(driver,storesNameList.get(0));

        if(getStoresNameList().isEmpty()){
            return false;
        }
        else{
            LoggerUtil.info("Footwear brands in your city: ");
            for(WebElement storesName:storesNameList){
                LoggerUtil.info(storesName.getText());
            }
        }
        return true;
    }

    public void selectThirdCategory() {
        WaitUtils.waitForElementToBeClickable(driver, thirdCategory).click();
    }

    public void selectFourthStore() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", fourthStore);
        WaitUtils.waitForElementToBeClickable(driver, fourthStore).click();
    }

    public boolean printStoreDetailsAndTopItems() {
        WaitUtils.waitForElementVisible(driver, storeName);

        LoggerUtil.info("======= Store Details =======");
        LoggerUtil.info("Store Name    : " + storeName.getText());
        LoggerUtil.info("Store Address : " + storeAddress.getText());

        By topItemsHeaderBy = By.xpath("//span[contains(normalize-space(),'Top items')]");

        List<WebElement> headers = driver.findElements(topItemsHeaderBy);
        if(!driver.getCurrentUrl().contains("/store")) return false;

        if (!headers.isEmpty()) {
            WebElement header = headers.get(0);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", header);
            LoggerUtil.info("======= Top Items in Store =======");
            for (WebElement item : topItems) {
                LoggerUtil.info(" - " + item.getText());
            }
        } else {
            LoggerUtil.info("Top Items section not available");
        }
        return true;
    }

    public void selectHomeFurnitureCategory() {
        WaitUtils.waitForElementToBeClickable(driver,homeFurnitureCategory);
        homeFurnitureCategory.click();
    }

    public void printAllStoreNames(){
        WaitUtils.waitForElementVisible(driver,storesNameList.get(0));

        LoggerUtil.info("======= Stores under Home & Furniture =======");
        for (WebElement store : storeNames) {
            String name = store.getText().trim();
            if (!name.isEmpty()) {
                LoggerUtil.info(" - " + name);
            }
        }
        LoggerUtil.info("============================================");
    }
}
