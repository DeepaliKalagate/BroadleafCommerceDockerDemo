package com.thoughtworks.script;
import com.thoughtworks.pages.HomePage;
import com.thoughtworks.pages.LoginPage;
import com.thoughtworks.pages.MerchandisePage;
import com.thoughtworks.pages.ProductListingPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class MerchandisePageTest extends BaseTest
{
    @Test()
    public void verifyMerchandiseTest() throws InterruptedException
    {
        LoginPage loginPage= new LoginPage(getDriver());
        loginPage.login(property.getProperty("email"),property.getProperty("password"));
        Assert.assertEquals(getDriver().findElement(By.className("material-icons")).isDisplayed(),true,"Verify Login is Successful");

        MerchandisePage merchandisePage=new MerchandisePage(getDriver());
        HomePage homePage=new HomePage(getDriver());
        merchandisePage=homePage.clickOnMerchandise();

        homePage.clickOnWomensMerchandise();
        ProductListingPage productListingPage=new ProductListingPage(getDriver());
        productListingPage.selectSortBy();

        merchandisePage.selectFilterByPrice();
        merchandisePage.selectProductImage();
        merchandisePage.selectSilverColor();
        merchandisePage.selectShirtSize("M");
        merchandisePage.productAddToWishlist();
        Thread.sleep(500);
        merchandisePage.clickOnDropdown();
        merchandisePage.clickOnProfile();
        merchandisePage.clickOnManageWishlist();

        //Getting list of Items from Cart
        List<String> addedProduct =new ArrayList<>();
        getDriver().findElements(By.xpath("//*[@id=\"productRow1251\"]/div[2]/div[1]/div[1]/div/a")).forEach(webElement1 -> {addedProduct.add(webElement1.getText());});
        System.out.println("The product name is : " +addedProduct);
        //Assert.assertTrue(addedProduct.contains("HEAT CLINIC HAND-DRAWN (WOMEN'S) SILVER (MEDIUM)"),"Product name is incorrect");
    }
}
