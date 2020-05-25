package com.thoughtworks.script;

import com.thoughtworks.pages.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class HotSaucePageTest extends BaseTest
{
    @Test()
    public void selectHotSauceTest() throws InterruptedException
    {
        LoginPage loginPage= new LoginPage(getDriver());
        loginPage.login(property.getProperty("email"),property.getProperty("password"));
        Assert.assertEquals(getDriver().findElement(By.className("material-icons")).isDisplayed(),true,"Verify Login is Successful");

        HotSaucePage hotSaucePage=new HotSaucePage(getDriver());
        HomePage homePage=new HomePage(getDriver());
        hotSaucePage=homePage.clickOnHotsauce();

        ProductListingPage productListingPage=new ProductListingPage(getDriver());
        productListingPage.selectSortBy();

        hotSaucePage.selectFilterBy();
        hotSaucePage.selectProductImage();
        Thread.sleep(500);

        ShippingCart shippingCart=new ShippingCart(getDriver());
        String element=shippingCart.verifyItemIsPresentOrNot();
        if(element.equals("OUT OF STOCK"))
        {
            getDriver().navigate().back();
        }
        else
        {
            hotSaucePage.productAddToCart();
            List<String> addedProducts = shippingCart.getProductsAddedInCart();
            Assert.assertTrue(addedProducts.contains("COOL CAYENNE PEPPER HOT SAUCE"),"Product name is incorrect");
        }
    }
}
