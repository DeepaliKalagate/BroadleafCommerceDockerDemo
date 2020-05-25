package com.thoughtworks.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductListingPage extends BasePage
{
    @FindBy(xpath = "//*[@id=\"sort\"]/div/a/span/span")
    private WebElement sortBy;

    @FindBy(xpath = "//a[contains(text(),'Price: Low to High')]")
    private WebElement selectPriceLowToHigh;

    public ProductListingPage(WebDriver driver)
    {
        super(driver);
    }

    public void selectSortBy() throws InterruptedException
    {
        sortBy.click();
        wait.until(ExpectedConditions.visibilityOf(selectPriceLowToHigh));
        selectPriceLowToHigh.click();
    }
}
