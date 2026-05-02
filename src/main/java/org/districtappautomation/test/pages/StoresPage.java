package org.districtappautomation.test.pages;

import org.districtappautomation.test.utility.WaitUtils;
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

    @FindBy(xpath ="//a[text()=\"Stores\"]")
    WebElement storesButton;

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
}
