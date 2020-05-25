package com.thoughtworks.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GiftCardPage extends BasePage
{
    @FindBy(xpath = "//div[@data-id='-15000']")
    private WebElement selectGiftCard;

    @FindBy(xpath = "//textarea[@name='itemAttributes[null]']")
    private WebElement personalMessage;

    @FindBy(xpath = "//div//div//div//div//div//div//div//div[3]//input[1]")
    private WebElement sender;

    @FindBy(xpath = "//div//div//div//div//div//div//div[4]//input[1]")
    private WebElement email;

    @FindBy(xpath = "//div[5]//div[1]//input[1]")
    private WebElement name;

    @FindBy(xpath = "//div[@class='color-inner Blue']")
    private WebElement selectColor;

    @FindBy(xpath = "//span[contains(text(),'Add to Cart')]")
    private WebElement clickAddToCart;

    @FindBy(xpath = "//li[@class='dropdown js-miniCart open']//i[@class='material-icons'][contains(text(),'shopping_cart')]")
    private WebElement clickOnCart;

    @FindBy(xpath = "//div[@class='mini-cart-item-info']")
    private WebElement clickOnCartSide;

    @FindBy(xpath = "//li[@class='dropdown js-miniCart open']//a[@class='btn btn-primary goto-full-cart'][contains(text(),'View Your Cart')]")
    private WebElement viewInCart;

    public GiftCardPage(WebDriver driver)
    {
        super(driver);
    }

    public void setSelectGiftCard()
    {
        selectGiftCard.click();
    }

    public void setPersonalMessage(String message)
    {
        personalMessage.sendKeys(message);
    }

    public void setSender(String senderName)
    {
        sender.sendKeys(senderName);
    }

    public void setEmail(String recipientEmail)
    {
        email.sendKeys(recipientEmail);
    }

    public void setName(String recipientName)
    {
        name.sendKeys(recipientName);
    }

    public void setSelectColor()
    {
        selectColor.click();
    }

    public void setClickAddToCart()
    {
        clickAddToCart.click();
    }

    public void setClickOnCart()
    {
       // clickOnCart.click();
    }

    public ShippingPage setGiftCard()
    {
        //clickOnCartSide.click();
        return new ShippingPage(driver);
    }
}
