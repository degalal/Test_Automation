package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Browser.BrowserAction.click;
import static Browser.BrowserAction.clickOn;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }


    public RegistrationPage clickOnRegister(){
       click(By.className("ico-register"));
        return new RegistrationPage(driver);
    }

    public LoginPage clickOnLogin(){
        click(By.className("ico-login"));
        return new LoginPage(driver);
    }


    public WishListPage clickOnWishList(){
        click(By.className("ico-login"));
        return new WishListPage(driver);
    }

    public ComputersPage clickOnComputers(){
        click(By.cssSelector("ul.top-menu.notmobile > li:nth-child(1) > a"));
        return new ComputersPage(driver);
    }

    public ShoppingCartPage clickOnCart(){
        click(By.cssSelector("#bar-notification > div > p > a"));
        return new ShoppingCartPage(driver);
    }




}
