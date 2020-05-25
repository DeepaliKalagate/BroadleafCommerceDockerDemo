package com.thoughtworks.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ClearancePage extends BasePage
{
    @FindBy(xpath = "//div[@class='col-md-4']//div[@data-id='8']")
    private WebElement clearanceItem;

    @FindBy(xpath = "//button[@class='btn btn-primary js-addToCart']")
    private WebElement addToCart;

    @FindBy(xpath = "//a[@class='btn btn-secondary']")
    private WebElement viewInCart;

    public ClearancePage(WebDriver driver)
    {
        super(driver);
    }

    public void selectProductImage()
    {
        clearanceItem.click();
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
