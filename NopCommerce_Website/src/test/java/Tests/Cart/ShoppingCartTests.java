package Tests.Cart;

import Pages.ComputersPage;
import Pages.ShoppingCartPage;
import Tests.Base.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

public class ShoppingCartTests extends BaseTests {


    @Test
    public void testAddItemsToCart(){
        ComputersPage computersPage = homePage.clickOnComputers();
        computersPage.clickCategory("Desktops");
        String ProductName = computersPage.getProductName();
        String item = computersPage.clickAddToCart(2);
        List<String> addedItems = Arrays.asList(ProductName, "The product has been added to your shopping cart");
        Assert.assertListContainsObject(addedItems,item,"");

    }



    @Test
    public void testRemoveFromShopCart(){

        ComputersPage computersPage = homePage.clickOnComputers();
        computersPage.clickCategory("Notebooks");
        computersPage.clickAddToCart(2);
        ShoppingCartPage cartPage = homePage.clickOnCart();
        String cartEmpty = cartPage.clickRemoveItem();

        Assert.assertEquals(cartEmpty,"Your Shopping Cart is empty!");

    }

    @Test
    public void testCheckOutCheckList(){

        ComputersPage computersPage = homePage.clickOnComputers();
        computersPage.clickCategory("Notebooks");
        computersPage.clickAddToCart(2);
        ShoppingCartPage cartPage = homePage.clickOnCart();
        cartPage.clickCheckOut();

        Assert.assertEquals(cartPage.getServiceWarning(),"Please accept the terms of service before the next step.");

    }

    @Test
    public void testCheckOutSuccessfully(){

        ComputersPage computersPage = homePage.clickOnComputers();
        computersPage.clickCategory("Notebooks");
        computersPage.clickAddToCart(2);
        ShoppingCartPage cartPage = homePage.clickOnCart();
        cartPage.clickServiceCheckList();
        cartPage.clickCheckOut();

        Assert.assertEquals( cartPage.getCheckOutMsg(),"Welcome, Please Sign In!");


    }


    @Test
    public void testTotalPrice() {
        ComputersPage computersPage = homePage.clickOnComputers();
        computersPage.clickCategory("Notebooks");


        int numProductsToAdd = 3;
        for (int i = 2; i <= numProductsToAdd; i++) {
            computersPage.clickAddToCart(i);
        }

        ShoppingCartPage cartPage = homePage.clickOnCart();


        List<String> productPriceElements = cartPage.getAllProductPrices();
        double totalLocalPrice = 0.0;

        for (String priceElement : productPriceElements) {
            String priceText = priceElement;
            String numericPrice = priceText.replaceAll("[^\\d.]", "");
            double productPrice = Double.parseDouble(numericPrice);
            totalLocalPrice += productPrice;
        }

        // Retrieve website's total price
        String websiteTotalPriceText = cartPage.getTotalPrice();
        String numericWebsiteTotalPrice = websiteTotalPriceText.replaceAll("[^\\d.]", "");
        double websiteTotalPrice = Double.parseDouble(numericWebsiteTotalPrice);


        Assert.assertEquals(websiteTotalPrice, totalLocalPrice);
    }







}
