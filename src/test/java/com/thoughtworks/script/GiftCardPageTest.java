package com.thoughtworks.script;

import com.thoughtworks.pages.GiftCardPage;
import com.thoughtworks.pages.HomePage;
import com.thoughtworks.pages.LoginPage;
import com.thoughtworks.pages.ShippingCart;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class GiftCardPageTest extends BaseTest
{
    @Test()
    public void selectGiftCardTest()
    {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(property.getProperty("email"), property.getProperty("password"));
        Assert.assertEquals(getDriver().findElement(By.className("material-icons")).isDisplayed(), true, "Verify Login is Successful");

        GiftCardPage giftCardPage;
        HomePage homePage = new HomePage(getDriver());
        giftCardPage = homePage.clickOnGiftCard();

        giftCardPage.setSelectGiftCard();
        giftCardPage.setPersonalMessage(property.getProperty("message"));
        giftCardPage.setSender(property.getProperty("name"));
        giftCardPage.setEmail(property.getProperty("recepeintEmail"));
        giftCardPage.setName(property.getProperty("recepeintName"));
        giftCardPage.setSelectColor();
        ShippingCart shippingCart = new ShippingCart(getDriver());
        String element = shippingCart.verifyItemIsPresentOrNot();
        if (element.equals("OUT OF STOCK"))
        {
            getDriver().navigate().back();
        }
        else
        {
            giftCardPage.setClickAddToCart();
            giftCardPage.setClickOnCart();
            List<String> addedProducts = shippingCart.getProductsAddedInCart();
           // Assert.assertTrue(addedProducts.contains("$5 GIFT CARD"), "Product name is incorrect");
        }
    }
}
