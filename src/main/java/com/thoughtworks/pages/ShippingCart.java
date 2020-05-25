package com.thoughtworks.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import java.util.List;

public class ShippingCart extends BasePage
{
    public ShippingCart(WebDriver driver)
    {
        super(driver);
    }

    public String verifyItemIsPresentOrNot()
    {
        String element=driver.findElement(By.xpath("//div[@class='col-sm-10']//button[@class='btn']")).getText();
        return element;
    }

    public List<String> getProductsAddedInCart()
    {
        List<String> addedProduct=new ArrayList<>();
        driver.findElements(By.xpath("//div[@class='col-sm-7']")).forEach(webElement1 -> {addedProduct.add(webElement1.getText());});
        return addedProduct;
    }
}
