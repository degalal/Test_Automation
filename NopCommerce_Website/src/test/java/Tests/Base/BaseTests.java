package Tests.Base;

import Browser.BrowserAction;
import Pages.HomePage;
import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTests {
    protected WebDriver driver;

    protected HomePage homePage;

    protected BrowserAction browserAction;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        browserAction = new BrowserAction(driver);
        homePage = new HomePage(driver);

    }

    @BeforeMethod
    public void beforeEachMethod(){
        driver.get("https://demo.nopcommerce.com/");



    }

    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus())
        {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    @AfterClass
    public void tearDown(){
         // driver.quit();
    }


}




