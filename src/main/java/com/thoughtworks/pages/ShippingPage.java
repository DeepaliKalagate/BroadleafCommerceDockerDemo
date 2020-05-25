package com.thoughtworks.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ShippingPage extends BasePage
{
    @FindBy(xpath = "//span[contains(text(),'Checkout')]")
    private WebElement clickOnCheckout;

    @FindBy(id = "fullName")
    private WebElement fullName;

    @FindBy(id = "addressLine1")
    private WebElement address1;

    @FindBy(id = "addressLine2")
    private WebElement address2;

    @FindBy(id="city")
    private WebElement city;

    @FindBy(id="stateProvinceRegion")
    private WebElement state;

    @FindBy(id="postalCode")
    private WebElement postal;

    @FindBy(id="phonePrimary")
    private WebElement phoneNumber;

    @FindBy(xpath = "//div[@class='col-sm-6 shipping-methods-wrapper']//div[2]//label[1]//span[1]")
    private WebElement shippingMethod;

    @FindBy(xpath = "//span[contains(text(),'Continue')]")
    private WebElement clickToContinue;

    @FindBy(xpath = "//a[contains(text(),'Collect On Delivery')]")
    private WebElement cashOnDelivery;

    @FindBy(xpath = "//span[contains(text(),'Continue')]")
    private WebElement continueShopping;

    @FindBy(xpath = "//div[@class='col-sm-4 checkout-stage-action']//span[contains(text(),'Place Your Order')]")
    private WebElement placeOrder;

    public ShippingPage(WebDriver driver)
    {
        super(driver);
    }

    public HomePage VerifyShippingPage(String name, String addressFirst, String addressTwo, String cityName, String selectState, String postalCode, String phoneNo)
    {
        wait.until(ExpectedConditions.visibilityOf(clickOnCheckout));
        clickOnCheckout.click();
        wait.until(ExpectedConditions.visibilityOf(fullName));
        fullName.sendKeys(name);
        address1.sendKeys(addressFirst);
        address2.sendKeys(addressTwo);
        city.sendKeys(cityName);
        Select select = new Select(state);
        select.selectByVisibleText(selectState);
        postal.sendKeys(postalCode);
        phoneNumber.sendKeys(phoneNo);
        wait.until(ExpectedConditions.visibilityOf(shippingMethod));
        shippingMethod.click();
        clickToContinue.click();
        wait.until(ExpectedConditions.visibilityOf(cashOnDelivery));
        cashOnDelivery.click();
        continueShopping.click();
        placeOrder.click();
        return new HomePage(driver);
    }
}
