package testPages;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import resources.Base;
import sun.rmi.runtime.Log;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class LogInTest extends Base {


    LoginPage loginPage= new LoginPage();


    @Test(priority = 1)
    public void searchBarTest() throws NullPointerException, IOException, InterruptedException {

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            sleepFor(5);
            loginPage.searchBox.sendKeys("toys for 2 year old");
            sleepFor(3);

    }

    @Test(priority = 0)
    public HomePage signingIn(){
        loginPage.signInButton.click();
        loginPage.searchBox.sendKeys("evanarafatbd@aol.com");
        loginPage.signInContinueButton.click();
        return new HomePage();
    }




    }

