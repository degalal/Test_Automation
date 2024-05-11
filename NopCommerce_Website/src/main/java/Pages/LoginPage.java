package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import static Browser.BrowserAction.*;

public class LoginPage {
    private WebDriver driver;

    private By userEmail = By.id("Email");

    private By userPassword = By.id("Password");

    private By notFound = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[1]/ul/li");

    private By Email_error = By.id("Email-error");

    private By passRecovery = By.cssSelector("#bar-notification > div > p");



    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public void setUserEmail(String user_Email){
        setData(userEmail,user_Email);

    }

    public void setUserPassword( String user_pass){
        setData(userPassword,user_pass);

    }

    public void clickLoginButton(){
        click(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button"));
    }

    public String checkUserFound(){
      return   get_Text(notFound);
    }

    public String checkEmailError(){
        return get_Text(Email_error);
    }

    public void clickForgotPassword(){
        click(By.linkText("Forgot password?"));

    }

    public void clickRecover(){
        click(By.cssSelector("form > div.buttons > button"));
    }

    public String verifyPasswordRecovery(){
        return get_Text(passRecovery);
    }


}
