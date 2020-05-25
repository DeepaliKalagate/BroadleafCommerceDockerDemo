package com.thoughtworks.script;
import com.thoughtworks.pages.RegisterPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest
{
    /*@Test
    public void registerTest() throws Exception
    {
        WebElement email=getDriver().findElement(By.id("customer.emailAddress"));
        email.sendKeys(property.getProperty("email"));

        WebElement firstName=getDriver().findElement(By.id("customer.firstName"));
        firstName.sendKeys(property.getProperty("name"));

        WebElement lastName=getDriver().findElement(By.id("customer.lastName"));
        lastName.sendKeys(property.getProperty("lastName"));

        WebElement password=getDriver().findElement(By.xpath("//div[@class='label-floating form-group error-group is-empty']//input[@id='password']"));
        password.sendKeys(property.getProperty("password"));

        WebElement confirmPassword=getDriver().findElement(By.id("passwordConfirm"));
        confirmPassword.sendKeys(property.getProperty("password"));

        WebElement btnRegister=getDriver().findElement(By.xpath("//button[contains(text(),'Register')]"));
        btnRegister.click();
        Assert.assertEquals(getDriver().findElement(By.className("material-icons")).isDisplayed(),true,"Verify Register is Successful");
    }*/

    @Test()
    public void validateRegisterIsSuccessful()
    {
        RegisterPage registerPage=new RegisterPage(getDriver());
        registerPage.register(property.getProperty("email"),property.getProperty("name"),
                property.getProperty("lastName"),property.getProperty("password"),
                property.getProperty("confirmPassword"));
        Assert.assertEquals(getDriver().findElement(By.className("material-icons")).isDisplayed(),true,"Verify Register is Successful");
    }
}
