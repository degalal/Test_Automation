package Browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserAction {
    private static WebDriver driver;

    public BrowserAction(WebDriver driver){
        BrowserAction.driver = driver;
    }

    public static void clickOn(By locator, By expected){

        driver.findElement(locator).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(expected));



    }



    public static void click(By locator){
        driver.findElement(locator).click();

    }



    public static String  get_ValidationText(By ErrorMsg){
        return driver.findElement(ErrorMsg).getText();
    }

    public static void setData(By Locator , String data){
        driver.findElement(Locator).sendKeys(data);
    }

    public static String  get_ProductsText(By productName){
        return driver.findElement(productName).getText();
    }




}
