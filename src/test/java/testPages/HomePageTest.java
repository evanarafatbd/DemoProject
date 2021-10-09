package testPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import resources.Base;

import java.util.List;

public class HomePageTest extends Base{

    LoginPage lp = new LoginPage();
    HomePage hp = new HomePage();

    @BeforeMethod
    public void loggingin(){
        lp.logIn();
    }


    @Test(priority =0)
    public void checkCartStatus(){
        hp.checkCart();
    }

    @Test(priority = 1)
    public void searchbar() throws InterruptedException {
        hp.searchBox.click();
        List<String> items= hp.addItems();
        for(String item: items){
            hp.searchBox.sendKeys(item);
            driver.navigate().back();
            sleepFor(3);
        }
    }


}
