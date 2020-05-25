package com.thoughtworks.script;
import com.thoughtworks.pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest
{
   /* @Test
    public void loginTest()
    {
        WebElement email=getDriver().findElement(By.id("username"));
        email.sendKeys(property.getProperty("email"));

        WebElement password=getDriver().findElement(By.id("password"));
        password.sendKeys(property.getProperty("password"));
        WebElement btnLogin=getDriver().findElement(By.xpath("//button[contains(text(),'Login')]"));
        btnLogin.click();
        Assert.assertEquals(getDriver().findElement(By.className("material-icons")).isDisplayed(),true,"Verify Login is Successful");
    }
*/
    @Test
    public void validateLoginIsSuccessful()
    {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(property.getProperty("email"),property.getProperty("password"));
        Assert.assertEquals(getDriver().findElement(By.className("material-icons")).isDisplayed(),true,"Verify Login is Successful");
    }
}
