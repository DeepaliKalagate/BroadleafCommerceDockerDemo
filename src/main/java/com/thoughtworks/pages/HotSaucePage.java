package com.thoughtworks.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HotSaucePage extends BasePage
{
    @FindBy(xpath = "//h4[contains(text(),'Price')]")
    private WebElement selectPrice;

    @FindBy(xpath = "//div[@id='collapse2']//div[2]//label[1]//span[@class='checkbox-material']//span[1]")
    private WebElement getSelectPrice;

    @FindBy(xpath = "//div[@class='col-md-4']//div[@data-id='14']")
    private WebElement viewHotSauce;

    @FindBy(xpath = "//span[contains(text(),'Add to Cart')]")
    private WebElement addToCart;

    @FindBy(xpath = "//a[@class='btn btn-secondary']")
    private WebElement viewInCart;

    public HotSaucePage(WebDriver driver)
    {
        super(driver);
    }

    public void selectFilterBy() throws InterruptedException
    {
        selectPrice.click();
        wait.until(ExpectedConditions.visibilityOf(getSelectPrice));
        getSelectPrice.click();
    }

    public void selectProductImage() throws InterruptedException
    {
        viewHotSauce.click();
    }


    public ShippingPage productAddToCart()
    {
        if(addToCart.isDisplayed())
        {
            addToCart.click();
            wait.until(ExpectedConditions.visibilityOf(viewInCart));
            viewInCart.click();
        }
        else
        {
            viewInCart.click();
        }
        return new ShippingPage(driver);
    }
}
