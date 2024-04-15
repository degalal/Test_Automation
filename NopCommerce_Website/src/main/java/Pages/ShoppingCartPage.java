package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Browser.BrowserAction.click;
import static Browser.BrowserAction.get_ValidationText;

public class ShoppingCartPage {
    private WebDriver driver;

    private By chosenProduct1 = By.cssSelector("div.product-essential > div.overview > div.product-name");

    private By cartButton = By.cssSelector("#topcartlink > a");

    private By removeItemButton = By.cssSelector("td.remove-from-cart > button");

    private By emptyMsg = By.cssSelector(" div.page-body > div > div");

    public ShoppingCartPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickCart(){
        click(cartButton);
    }

    public String clickRemoveItem(){
        click(removeItemButton);
        return get_ValidationText(emptyMsg);

    }

}


