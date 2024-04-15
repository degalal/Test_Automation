package Tests.ComputersTests;

import Pages.ComputersPage;
import Pages.ShoppingCartPage;
import Tests.Base.BaseTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ComputersPageTests extends BaseTests {

    @Test
    public void testAddItemsToCart(){
      ComputersPage computersPage = homePage.clickOnComputers();
      computersPage.clickCategory("Notebooks");
      String ProductName = computersPage.getProductName();
      String item = computersPage.clickAddToCart(2);
      List<String> addedItems = Arrays.asList(ProductName, "The product has been added to your shopping cart");
      Assert.assertListContainsObject(addedItems,item,"");


    }

    @Test
    public void testRemoveFromShopCart(){
        ShoppingCartPage cartPage = homePage.clickOnCart();
        cartPage.clickCart();
        String cartEmpty = cartPage.clickRemoveItem();

        Assert.assertEquals(cartEmpty,"Your Shopping Cart is empty!");



    }




    @Test
    public void testRequiredSpecs(){
        ComputersPage computersPage = homePage.clickOnComputers();
        computersPage.clickCategory("Desktops");
        computersPage.clickAddToCart(1);
        computersPage.clickAddToButton();
        Assert.assertEquals(computersPage.getSpecsErrorMsg(),"Please select RAM\n" +
                "Please select HDD");


    }

    @Test
    public void testDropDownRAM(){
        String option = "2 GB";
        ComputersPage computersPage = homePage.clickOnComputers();
        computersPage.clickCategory("Desktops");
        computersPage.clickAddToCart(1);

       computersPage.selectFromDropDown(option);
        var selectedOptions = computersPage.getSelectedOptions();
       Assert.assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
       Assert.assertTrue(selectedOptions.contains(option), "Option not selected");

    }

    @Test
    public void testRadioButtonHDD(){



    }

}





