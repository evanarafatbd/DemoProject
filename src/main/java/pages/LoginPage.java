package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resources.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoginPage extends Base {

    //@FindBy(how = How.CSS, using = "#search > span.search-text")
    @FindBy(id="#search") //Naveen's way of writing
    public WebElement searchWebElement;

    @FindBy(xpath = "//a[normalize-space()='Sign in securely']")
    public WebElement signInButton;

    @FindBy(xpath = "//input[@id='ap_email']")
    public WebElement signInTextBox;

    @FindBy(xpath = "///input[@id='continue']")
    public WebElement signInContinueButton;

    @FindBy(xpath = "//input[@id='ap_password']")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//input[@id='signInSubmit']")
    public WebElement passwordSignButton;

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    public WebElement searchBox;

    public LoginPage(){

        PageFactory.initElements(driver, this);
    }

    public HomePage logIn(){
        signInButton.click();
        searchBox.sendKeys("evanarafatbd@aol.com");
        signInContinueButton.click();
        return new HomePage();
    }



}
