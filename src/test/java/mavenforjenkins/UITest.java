package mavenforjenkins;

import java.util.Optional; // optional: not required if you're using TestNG's @Optional
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UITest 
{
    @Parameters("Browser")
    @Test
    public void startBrowser(@Optional("chrome") String browser)
    {
        System.out.println("Parameter value is " + browser);
        WebDriver driver = null;

        if(browser.equalsIgnoreCase("chrome"))
        {
            ChromeOptions opt = new ChromeOptions();
            opt.addArguments("--headless");
            opt.addArguments("--no-sandbox");
            opt.addArguments("--disable-dev-shm-usage");
            driver = new ChromeDriver(opt);
        }
        else if(browser.equalsIgnoreCase("edge"))
        {
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        Assert.assertTrue(driver.getTitle().contains("Orange"), "Title does not match");
        driver.quit();
    }
}
