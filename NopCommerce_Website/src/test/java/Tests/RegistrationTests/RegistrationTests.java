package Tests.RegistrationTests;

import Pages.RegistrationPage;

import Tests.Base.BaseTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import static Browser.BrowserAction.click;


public class RegistrationTests extends BaseTests {

    @Test(groups = "registration")


    public void  testSuccessfulRegistration(){
       RegistrationPage registrationPage = homePage.clickOnRegister();
       registrationPage.setFirstName("deee");
       registrationPage.setLastName("lkkk");
       registrationPage.setEmail("deena.galal208900@gmail.com");
       registrationPage.setPassword("testautomation");
       registrationPage.confirmPassword("testautomation");
       click(By.id("register-button"));
       Assert.assertEquals(registrationPage.checkSuccessfulRegisterMsg(),"Your registration completed");


    }

    @Test
    public void testUnSuccessfulRegistration(){
        RegistrationPage registrationPage = homePage.clickOnRegister();
        registrationPage.setFirstName("deee");
        registrationPage.setLastName("lkkk");
        registrationPage.setEmail("deena.galal28@gmail.com");
        registrationPage.setPassword("testautomation");
        registrationPage.confirmPassword("testautomation");
        click(By.id("register-button"));
        Assert.assertEquals(registrationPage.checkExistingEmail(),"The specified email already exists");



    }
    //////////// Names Input Fields Validation

    @Test
    public void testFirstNameIsBlank(){
        RegistrationPage registrationPage = homePage.clickOnRegister();
        registrationPage.setFirstName("");
        click(By.id("register-button"));
        Assert.assertEquals(registrationPage.checkFirstNameErrorMsg(),"First name is required.");


    }

    @Test
    public void testNamesIncludeCharOnly(){
        RegistrationPage registrationPage = homePage.clickOnRegister();
        registrationPage.setFirstName("123");
        registrationPage.setLastName("&!_");
        click(By.id("register-button"));
        Assert.assertEquals(registrationPage.checkFirstNameErrorMsg(),"First name include characters only");

    }



    @Test
    public void testLastNameIsBlank(){
        RegistrationPage registrationPage = homePage.clickOnRegister();
        registrationPage.setLastName("");
        click(By.id("register-button"));
        registrationPage.checkLastNameErrorMsg();
        Assert.assertEquals(registrationPage.checkLastNameErrorMsg(),"Last name is required.");

    }

    ////////////// Email Field Validation

    @Test
    public void testEmailIsBlank(){
        RegistrationPage registrationPage = homePage.clickOnRegister();
        registrationPage.setEmail("");
        click(By.id("register-button"));
        Assert.assertEquals(registrationPage.checkEmailError(),"Email is required.");
    }

    @Test
    public void testInValidEmail(){
        RegistrationPage registrationPage = homePage.clickOnRegister();
        registrationPage.setEmail("eeeee");
        click(By.id("register-button"));
        Assert.assertEquals(registrationPage.checkEmailError(),"Wrong email");

    }

    ///////// Password Field Validation

    @Test
    public void testPasswordLessThan6(){
        RegistrationPage registrationPage = homePage.clickOnRegister();
        registrationPage.setPassword("123");
        registrationPage.confirmPassword("123");
        Assert.assertEquals(registrationPage.checkPassErrorMsg(),"must have at least 6 characters");



    }

    @Test
    public void testPasswordUnMatch(){
        RegistrationPage registrationPage = homePage.clickOnRegister();
        registrationPage.setPassword("12345678");
        registrationPage.confirmPassword("123");
        click(By.id("register-button"));
        Assert.assertEquals(registrationPage.checkConfirmPassError(),"The password and confirmation password do not match.");


    }

    @Test
    public void testPasswordIsBlank(){
        RegistrationPage registrationPage = homePage.clickOnRegister();
        registrationPage.setPassword("");
        registrationPage.confirmPassword("");
        click(By.id("register-button"));
        Assert.assertEquals(registrationPage.checkPassRequired(),"Password is required.");
    }











}
