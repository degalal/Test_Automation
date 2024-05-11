package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
    private By addToCartP1 = By.cssSelector("#add-to-cart-button-1");
    private By specsErrorMsg = By.cssSelector("#bar-notification > div");
    private By dropDown = By.cssSelector("#product_attribute_2");
    private By radioCheck = By.cssSelector("#product_attribute_3_6");

    private By category = By.xpath("//strong[contains(text(),\"Categories\")]/../following-sibling::div/ul/li");







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
        return get_Text(product1);

    }





    public String clickAddToCart(int productNumber) {

        switch (productNumber) {
            case 1:
                clickOn(addToCartButton(productNumber), productSpecs);
                return get_Text(productSpecs);

            case 2:
            case 3:
                clickOn(addToCartButton(productNumber), addedToCartMsg);
                return get_Text(addedToCartMsg);


            default:
                System.out.println("Invalid product number");
        }
        return null;
    }

    public By addToCartButton(int productNumber){
        return By.cssSelector("div:nth-child("+productNumber+") > div > div.details > div.add-info > div.buttons > button.button-2.product-box-add-to-cart-button");
    }



    public void clickAddToButton(){
        clickOn(addToCartP1,specsErrorMsg);

    }

    public String getSpecsErrorMsg(){
        return get_Text(specsErrorMsg);
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

    public void clickRadioButton(){
        click(radioCheck);
    }

    public void scrollToAddToCartButton(){
        scroll(product1);

    }


}
