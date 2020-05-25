package com.thoughtworks.script;

import com.thoughtworks.pages.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class ShippingPageTest extends BaseTest
{
    @Test()
    public void verifyShippingPageTest() throws InterruptedException
    {
        LoginPage loginPage= new LoginPage(getDriver());
        loginPage.login(property.getProperty("email"),property.getProperty("password"));
        Assert.assertEquals(getDriver().findElement(By.className("material-icons")).isDisplayed(),true,"Verify Login is Successful");
        HomePage homePage=new HomePage(getDriver());
        homePage.clickOnClearance();
        ClearancePage clearancePage=new ClearancePage(getDriver());
        ShippingPage shippingPage=new ShippingPage(getDriver());
        clearancePage.selectProductImage();
        ShippingCart shippingCart=new ShippingCart(getDriver());
        String element=shippingCart.verifyItemIsPresentOrNot();
        if(element.equals("OUT OF STOCK"))
        {
            getDriver().navigate().back();
        }
        else
        {
            clearancePage.productAddToCart();
            List<String> addedProducts = shippingCart.getProductsAddedInCart();
            System.out.println("Product Name : "+addedProducts);
            Assert.assertTrue(addedProducts.contains("BLAZIN' SADDLE XXX HOT HABANERO PEPPER SAUCE"),"Product name is incorrect");
            shippingPage.VerifyShippingPage(property.getProperty("fullName"),
                    property.getProperty("address1"),property.getProperty("address2"),
                    property.getProperty("city"),property.getProperty("state"),
                    property.getProperty("postal"),property.getProperty("mobileno"));
            Assert.assertTrue(homePage.verifyUserName());
        }
    }
}
