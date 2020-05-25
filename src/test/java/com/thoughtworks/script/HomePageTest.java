package com.thoughtworks.script;
import com.thoughtworks.pages.HomePage;
import com.thoughtworks.pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest
{
    @Test()
    public void verifyHotSauceLinkTest()
    {
        LoginPage loginPage= new LoginPage(getDriver());
        loginPage.login(property.getProperty("email"),property.getProperty("password"));
        Assert.assertEquals(getDriver().findElement(By.className("material-icons")).isDisplayed(),true,"Verify Login is Successful");

        HomePage homePage=new HomePage(getDriver());
        boolean userName=homePage.verifyUserName();
        Assert.assertTrue(userName);
    }
}
