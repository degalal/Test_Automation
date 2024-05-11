package Tests.ComputersTests;

import Pages.ComputersPage;
import Pages.ShoppingCartPage;
import Tests.Base.BaseTests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;
import java.util.*;
import java.util.List;


public class ComputersPageTests extends BaseTests {


    @Test
    public void testRequiredDesktopSpecsMissing(){
        ComputersPage computersPage = homePage.clickOnComputers();
        computersPage.clickCategory("Desktops");
        computersPage.clickAddToCart(1);
        computersPage.clickAddToButton();
        Assert.assertEquals(computersPage.getSpecsErrorMsg(),"Please select RAM\n" +
                "Please select HDD");


    }

    @Test
    public void testRequiredSpecsSuccessful(){
        String option = "2 GB";
        ComputersPage computersPage = homePage.clickOnComputers();
        computersPage.clickCategory("Desktops");
        computersPage.clickAddToCart(1);

        computersPage.clickRadioButton();
        computersPage.selectFromDropDown(option);
        var selectedOptions = computersPage.getSelectedOptions();

        computersPage.clickAddToButton();



       Assert.assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
       Assert.assertTrue(selectedOptions.contains(option), "Option not selected");
       Assert.assertEquals(computersPage.getSpecsErrorMsg(),"The product has been added to your shopping cart");





    }


}





