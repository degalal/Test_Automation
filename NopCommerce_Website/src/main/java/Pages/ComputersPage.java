package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static Browser.BrowserAction.*;

public class ComputersPage {
    private WebDriver driver;



    private By desktopsLink = By.cssSelector("div > div:nth-child(1) > div > h2 > a");

    private By notebooksLink = By.cssSelector(" div > div:nth-child(2) > div > h2 > a");

    private By softwareLink = By.cssSelector(" div > div:nth-child(3) > div > h2 > a");
    private By product1 = By.cssSelector("div:nth-child(1) > div > div.details > h2 > a");

    private By productSpecs = By.cssSelector("div.product-essential > div.overview > div.product-name");

    private By addedToCartMsg = By.cssSelector("#bar-notification > div > p");

    private By add1ToCartButton = By.cssSelector("div:nth-child(1) > div > div.details > div.add-info > div.buttons > button.button-2.product-box-add-to-cart-button");
    private By add2ToCartButton = By.cssSelector("div:nth-child(2) > div > div.details > div.add-info > div.buttons > button.button-2.product-box-add-to-cart-button");

    private By add3ToCartButton = By.cssSelector("div:nth-child(3) > div > div.details > div.add-info > div.buttons > button.button-2.product-box-add-to-cart-button");

    private By addToCartP1 = By.cssSelector("#add-to-cart-button-1");

    private By specsErrorMsg = By.cssSelector("#bar-notification > div");

    private By dropDown = By.cssSelector("#product_attribute_2");

    private By radioCheck = By.cssSelector("#product_attribute_3_6");
    public ComputersPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickCategory(String categoryName) {
        switch (categoryName) {
            case "Desktops":
                click(desktopsLink);
                break;
            case "Notebooks":
                click(notebooksLink);
                break;
            case "Software":
                click(softwareLink);
                break;

            default:
                System.out.println("Invalid Category Name");
                break;
        }


    }

    public String getProductName() {
        return get_ProductsText(product1);

    }


    public String clickAddToCart(int productNumber) {

        switch (productNumber) {
            case 1:
                clickOn(add1ToCartButton, productSpecs);

                return get_ValidationText(productSpecs);
            case 2:
                clickOn(add2ToCartButton, addedToCartMsg);
                return get_ValidationText(addedToCartMsg);

            case 3:
                clickOn(add3ToCartButton, addedToCartMsg);
                return get_ValidationText(addedToCartMsg);


            default:
                System.out.println("Invalid product number");
        }
        return null;
    }

    public void clickAddToButton(){
        clickOn(addToCartP1,specsErrorMsg);

    }

    public String getSpecsErrorMsg(){
        return get_ValidationText(specsErrorMsg);
    }

    public void selectFromDropDown(String option){
        findDropDownElement().selectByVisibleText(option);
    }

    public List<String> getSelectedOptions(){
        List<WebElement> selectedElements = findDropDownElement().getAllSelectedOptions();
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    private Select findDropDownElement(){
        return new Select(driver.findElement(dropDown));
    }


}
