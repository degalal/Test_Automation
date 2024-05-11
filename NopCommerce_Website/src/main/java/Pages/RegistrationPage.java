package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Browser.BrowserAction.*;

public class RegistrationPage {
    private WebDriver driver;
    private By firstName = By.id("FirstName");
    private By lastName = By.id("LastName");

    private By Email = By.id("Email");

    private By password = By.id("Password");

    private By passwordConfirmed = By.id("ConfirmPassword");

    private By successfulRegisterMsg = By.cssSelector(" div.page-body > div.result");

    private By passErrorMsg = By.cssSelector("#Password-error > ul > li");

    private By confirmPassError = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[4]/div[2]/div[2]/span[2]");


    private By passRequiredError = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[4]/div[2]/div[1]/span[2]");


    private By emailRequiredError = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[5]/span[2]");

    private By existingEmailError = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]");

    private By firstNameRequiredError = By.id("FirstName-error");

    private By lastNameRequiredError = By.id("LastName-error");


    /////////////////////////Filling Registration Form////////////////////////////////////////


    public RegistrationPage(WebDriver driver){
        this.driver=driver;
    }

    public void setFirstName(String firstname) {

        setData(firstName,firstname);

    }
    public void setLastName(String lastname) {
        setData(lastName,lastname);

    }
    public void setEmail(String email) {
        setData(Email,email);

    }

    public void setPassword(String pass) {
        setData(password,pass);

}

public void confirmPassword(String pass){
        setData(passwordConfirmed,pass);
}


//////////////Validating Input Fields/////////////////////




public String checkSuccessfulRegisterMsg(){
     return get_Text(successfulRegisterMsg);

}

public String checkExistingEmail(){
        return get_Text(existingEmailError);
    }

    public String checkEmailError(){
        return get_Text(emailRequiredError);

    }



public String checkPassErrorMsg(){
     return get_Text(passErrorMsg);
}

    public String checkConfirmPassError(){
        return get_Text(confirmPassError);

    }

    public String checkPassRequired(){
     return get_Text(passRequiredError);
    }


    public String checkFirstNameErrorMsg(){
        return get_Text(firstNameRequiredError);
    }

    public String checkLastNameErrorMsg(){
        return get_Text(lastNameRequiredError);
    }



}
