package Tests.Cart;

import Pages.ShoppingCartPage;
import Tests.Base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartTests extends BaseTests {
@Test
    public void testRemoveFromShopCart(){
       ShoppingCartPage cartPage = homePage.clickOnCart();
       cartPage.clickCart();
      String cartEmpty = cartPage.clickRemoveItem();

    Assert.assertEquals(cartEmpty,"Your Shopping Cart is empty!");



    }
}
