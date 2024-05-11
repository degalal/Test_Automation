package Browser;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserAction {
    private static WebDriver driver;

    public BrowserAction(WebDriver driver){
        BrowserAction.driver = driver;
    }



    public static void clickOn(By locator, By expected) {
        try {
            driver.findElement(locator).click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOfElementLocated(expected));

        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + e.getMessage());
        }
    }



    public static void scroll(By locator){

        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            WebElement element = driver.findElement(locator);
            js.executeScript("arguments[0].scrollIntoView();", element);

        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + e.getMessage());
        }



    }


    public static void click(By locator){
        driver.findElement(locator).click();

    }



    public static String  get_Text(By Element){
        return driver.findElement(Element).getText();
    }

    public static void setData(By Locator , String data){
        driver.findElement(Locator).sendKeys(data);
    }




}
