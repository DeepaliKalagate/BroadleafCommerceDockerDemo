package com.thoughtworks.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage
{
    //Page Factory-Object Repository
    @FindBy(id="customer.emailAddress")
    private WebElement email;

    @FindBy(id="customer.firstName")
    private WebElement firstName;

    @FindBy(id = "customer.lastName")
    private WebElement lastName;

    @FindBy(xpath = "//div[@class='label-floating form-group error-group is-empty']//input[@id='password']")
    private WebElement password;

    @FindBy(id="passwordConfirm")
    private WebElement confirmPassword;

    @FindBy(xpath = "//button[contains(text(),'Register')]")
    private WebElement btnRegister;

    public RegisterPage(WebDriver driver)
    {
        super(driver);
    }

    //Actions
    public HomePage register(String userName, String fName, String lName, String password1, String confirmPass)
    {
        email.sendKeys(userName);
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        password.sendKeys(password1);
        confirmPassword.sendKeys(confirmPass);
        btnRegister.click();
        return new HomePage(driver);
    }
}
