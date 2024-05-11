package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static Browser.BrowserAction.*;

public class ShoppingCartPage {
    private WebDriver driver;



    private By removeItemButton = By.cssSelector("td.remove-from-cart > button");

    private By emptyMsg = By.cssSelector(" div.page-body > div > div");

    private By checkOut = By.id("checkout");

    private By serviceWarning = By.cssSelector("#terms-of-service-warning-box > p");

    private By serviceCheck = By.id("termsofservice");

    private By welcomeMsg = By.cssSelector(" div.page-title > h1");

    private By totalPrice = By.cssSelector(" span > strong");



    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }


    public String clickRemoveItem() {
        click(removeItemButton);
        return get_Text(emptyMsg);

    }

    public void clickCheckOut() {
        click(checkOut);

    }

    public String getServiceWarning() {
        return get_Text(serviceWarning);

    }

    public void clickServiceCheckList() {
        click(serviceCheck);

    }



    public String getCheckOutMsg() {
        return get_Text(welcomeMsg);
    }


    public List<String> getAllProductPrices() {
        List<String> productPrices = new ArrayList<>();


        By productPriceLocator1 = By.cssSelector("tr:nth-child(1) > td.subtotal > span");
        By productPriceLocator2 = By.cssSelector("tr:nth-child(2) > td.subtotal > span");

        WebElement productPriceElement1 = driver.findElement(productPriceLocator1);
        WebElement productPriceElement2 = driver.findElement(productPriceLocator2);

        String priceText1 = productPriceElement1.getText();
        String priceText2 = productPriceElement2.getText();

        productPrices.add(priceText1);
        productPrices.add(priceText2);

        return productPrices;
    }



    public String getTotalPrice(){
        return get_Text(totalPrice);
    }

}


