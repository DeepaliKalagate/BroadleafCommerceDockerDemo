package com.thoughtworks.script;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class BaseTest
{
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();

    public static Properties property;
    public static FileInputStream fileInputStream;
    public static String filePath="/Users/deepalikalagate/Documents/BroadleafCommerceDockerDemo/Config/config.properties";

    public BaseTest()
    {
        property = new Properties();
        try
        {
            fileInputStream = new FileInputStream(filePath);
            property.load(fileInputStream);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    @Parameters(value={"browser"})
    public void setupTest (String browser) throws MalformedURLException
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);
        driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities));
        String url = property.getProperty("URL");
        getDriver().get(url);
    }

    public WebDriver getDriver()
    {
        return driver.get();
    }

    @AfterMethod
    public void tearDown()
    {
        getDriver().quit();
    }

    @AfterClass
    void terminate ()
    {
        driver.remove();
    }
}
