package Tests.LoginTests;

import Pages.LoginPage;
import Tests.Base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginFieldsTests extends BaseTests {


    @Test(dependsOnGroups = "registration")
    public void testSuccessfulLogin(){
        LoginPage loginPage = homePage.clickOnLogin();
        loginPage.setUserEmail("deena.galal2080@gmail.com");
        loginPage.setUserPassword("testautomation");
        loginPage.clickLoginButton();
        Assert.assertEquals("https://demo.nopcommerce.com/",driver.getCurrentUrl() );
    }

    @Test void unSuccessfulLogin(){
        LoginPage loginPage = homePage.clickOnLogin();
        loginPage.setUserEmail("ahmaom@gmail.com"); //un existing Email in DB
        loginPage.setUserPassword("test");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.checkUserFound(),"No customer account found");

    }

    @Test
    public void testWrongEmail(){
        LoginPage loginPage = homePage.clickOnLogin();
        loginPage.setUserEmail("hhhhh");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.checkEmailError(),"Wrong email");
    }

    @Test
    public void testEmailIsBlank(){
        LoginPage loginPage = homePage.clickOnLogin();
        loginPage.setUserEmail("");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.checkEmailError(),"Please enter your email");
    }
    @Test
    public void testWrongPassword(){
        LoginPage loginPage = homePage.clickOnLogin();
        loginPage.setUserEmail("deena.galal2806@gmail.com");
        loginPage.setUserPassword("hhhh");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.checkUserFound(),"The credentials provided are incorrect");
    }




}
