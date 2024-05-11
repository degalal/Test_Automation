package Tests.LoginTests;

import Pages.LoginPage;
import Tests.Base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PasswordRecoveryTests extends BaseTests {

    @Test
    public void testSuccessfulEmailRecovery(){
       LoginPage loginPage = homePage.clickOnLogin();
       loginPage.clickForgotPassword();
       loginPage.setUserEmail("deena.galal2080@gmail.com");
       loginPage.clickRecover();
        Assert.assertEquals(loginPage.verifyPasswordRecovery(),"Email with instructions has been sent to you.");


    }

    @Test
    public void testUnSuccessfulEmailRecovery(){
        LoginPage loginPage = homePage.clickOnLogin();
        loginPage.clickForgotPassword();
        loginPage.setUserEmail("ahamd6@gmail.com");
        loginPage.clickRecover();
        Assert.assertEquals(loginPage.verifyPasswordRecovery(),"Email not found.");


    }

    @Test
    public void testInvalidEmail(){
        LoginPage loginPage = homePage.clickOnLogin();
        loginPage.clickForgotPassword();
        loginPage.setUserEmail("ahamd6");
        loginPage.clickRecover();
        Assert.assertEquals(loginPage.checkEmailError(),"Wrong email");


    }
}
