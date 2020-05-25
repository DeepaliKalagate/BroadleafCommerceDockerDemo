package com.thoughtworks.script;
import com.thoughtworks.pages.ClearancePage;
import com.thoughtworks.pages.HomePage;
import com.thoughtworks.pages.LoginPage;
import com.thoughtworks.pages.ShippingCart;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class ClearancePageTest extends BaseTest
{
    @Test()
    public void verifyClearancePageTest()
    {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(property.getProperty("email"), property.getProperty("password"));
        Assert.assertEquals(getDriver().findElement(By.className("material-icons")).isDisplayed(), true, "Verify Login is Successful");

        ClearancePage clearancePage;
        HomePage homePage = new HomePage(getDriver());
        clearancePage = homePage.clickOnClearance();

        clearancePage.selectProductImage();
        ShippingCart shippingCart = new ShippingCart(getDriver());
        String element = shippingCart.verifyItemIsPresentOrNot();
        if (element.equals("OUT OF STOCK"))
        {
            getDriver().navigate().back();
        }
        else
        {
            clearancePage.productAddToCart();
            List<String> addedProducts = shippingCart.getProductsAddedInCart();
            Assert.assertTrue(addedProducts.contains("BLAZIN' SADDLE XXX HOT HABANERO PEPPER SAUCE"), "Product name is incorrect");
        }
    }
}
