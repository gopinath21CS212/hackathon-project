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
    @FindBy(xpath = "//a[normalize-space()='Stores']")
    WebElement storesTab;
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
                System.out.println(storesName.getText());
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

    public void printStoreDetailsAndTopItems() {

        WaitUtils.waitForElementVisible(driver, storeName);
        System.out.println("======= Store Details =======");
        System.out.println("Store Name    : " + storeName.getText());
        System.out.println("Store Address : " + storeAddress.getText());

        By topItemsHeaderBy =
                By.xpath("//span[contains(normalize-space(),'Top items')]");

        List<WebElement> headers = driver.findElements(topItemsHeaderBy);

        if (!headers.isEmpty()) {
            WebElement header = headers.get(0);
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].scrollIntoView(true);", header);
            System.out.println("======= Top Items in Store =======");
            for (WebElement item : topItems) {
                System.out.println(" - " + item.getText());
            }
        } else {
            System.out.println("Top Items section not available");
        }
    }
    public void selectHomeFurnitureCategory() {
        WaitUtils.waitForElementToBeClickable(driver,homeFurnitureCategory);
        homeFurnitureCategory.click();
    }
    public void printAllStoreNames() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("======= Stores under Home & Furniture =======");
        for (WebElement store : storeNames) {
            String name = store.getText().trim();
            if (!name.isEmpty()) {
                System.out.println(" - " + name);
            }
        }
        System.out.println("============================================");
    }
}
