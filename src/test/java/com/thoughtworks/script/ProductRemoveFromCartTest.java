package com.thoughtworks.script;

import com.thoughtworks.pages.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class ProductRemoveFromCartTest extends BaseTest
{
    @Test
    public void productRemoveFromCartTest() throws InterruptedException
    {
        LoginPage loginPage= new LoginPage(getDriver());
        loginPage.login(property.getProperty("email"),property.getProperty("password"));
        Assert.assertEquals(getDriver().findElement(By.className("material-icons")).isDisplayed(),true,"Verify Login is Successful");
        ClearancePage clearancePage=new ClearancePage(getDriver());
        HomePage homePage=new HomePage(getDriver());
        clearancePage=homePage.clickOnClearance();


        ProductRemoveFromCartPage removeFromCartPage=new ProductRemoveFromCartPage(getDriver());
        removeFromCartPage.selectProduct();
        Thread.sleep(5000);
        ShippingCart shippingCart=new ShippingCart(getDriver());
        String element=shippingCart.verifyItemIsPresentOrNot();
        if(element.equals("OUT OF STOCK"))
        {
            getDriver().navigate().back();
        }
        else
        {
            removeFromCartPage.productAddToCart();
            List<String> addedProducts = shippingCart.getProductsAddedInCart();
            Assert.assertTrue(addedProducts.contains("BLAZIN' SADDLE XXX HOT HABANERO PEPPER SAUCE"),"Product name is incorrect");

            for (int i=0;i<addedProducts.size();i++)
            {
                removeFromCartPage.removeProdutsFromCart();
                Thread.sleep(500);
            }
            removeFromCartPage.clickOnDropdown();
            removeFromCartPage.clickOnLogout();
            Assert.assertEquals(getDriver().findElement(By.xpath("//a[contains(text(),'Login')]"))
                    .isDisplayed(), true,"Verify Logout Successful");
        }
    }
}
