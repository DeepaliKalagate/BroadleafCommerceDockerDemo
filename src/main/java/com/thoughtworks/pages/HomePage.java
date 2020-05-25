package com.thoughtworks.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
    @FindBy(className = "material-icons")
    private WebElement userNameLable;

    @FindBy(xpath = "//div[@id='left-nav']//span[contains(text(),'Hot Sauces')]")
    private WebElement hotSauses;

    @FindBy(xpath="//div[@id='left-nav']//span[contains(text(),'Merchandise')]")
    private WebElement clickOnMerchandise;

    @FindBy(xpath = "//div[@id='left-nav']//ul[@class='nav navbar-nav main-menu']//li[@class='dropdown']//ul[@class='dropdown-menu dropdown-with-icons']//li//a[contains(text(),'Womens')]")
    private WebElement women;

    @FindBy(xpath = "//div[@id='left-nav']//span[contains(text(),'Clearance')]")
    private WebElement clickOnClearance;

    @FindBy(xpath = "//div[@id='left-nav']//span[contains(text(),'Gift Cards')]")
    private WebElement clickOnGiftCard;

    //Initializing the Page Objects
    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    public boolean verifyUserName()
    {
        return userNameLable.isDisplayed();
    }

    public HotSaucePage clickOnHotsauce()
    {
        hotSauses.click();
        return new HotSaucePage(driver);
    }

    public MerchandisePage clickOnMerchandise()
    {
        clickOnMerchandise.click();
        return new MerchandisePage(driver);
    }

    public void clickOnWomensMerchandise()
    {
        Actions actions=new Actions(driver);
        actions.moveToElement(clickOnMerchandise).build().perform();
        women.click();
    }

    public ClearancePage clickOnClearance()
    {
        clickOnClearance.click();
        return new ClearancePage(driver);
    }

    public GiftCardPage clickOnGiftCard()
    {
        clickOnGiftCard.click();
        return new GiftCardPage(driver);
    }
}
