package com.thoughtworks.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HotSauce extends BasePage
{
    @FindBy(xpath = "//div[@class='col-md-4']//div[@data-id='1']")
    private WebElement viewHotSauce;

    @FindBy(xpath = "//span[contains(text(),'Add to Cart')]")
    private WebElement addToCart;

    @FindBy(xpath = "//a[@class='btn btn-secondary']")
    private WebElement viewInCart;

    public HotSauce(WebDriver driver)
    {
        super(driver);
    }

    public void viewHotSuaceProduct()
    {
        viewHotSauce.click();
    }

    public void productAddToCart()
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
    }
}
