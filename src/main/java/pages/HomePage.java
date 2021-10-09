package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import resources.Base;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends Base {

    //@FindBy(how = How.CSS, using = "#search > span.search-text")
    @FindBy(id="#search") //Naveen's way of writing
    public WebElement searchWebElement;

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    public WebElement searchBox;

    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    public WebElement searchButton;

    @FindBy(xpath = "//a[@id='nav-logo-sprites']")
    public WebElement amazonLogo;

    @FindBy(xpath = "//a[normalize-space()='Toys & Games']")
    public WebElement toysGamesTab;

    @FindBy(xpath = "//span[@class='nav-cart-icon nav-sprite']")
    public WebElement cartButton;

    public HomePage(){

        PageFactory.initElements(driver, this);
    }
    public List<String> addItems() {
        List<String> items = new ArrayList<String>();
        items.add("Toys");
        items.add("cat food");
        items.add("dog food");
        return items;
    }

    public void addingItems(){
        searchBox.click();
        List<String> items= addItems();
        for(String item: items){
            searchBox.sendKeys(item);
        }


    }

    public ToysGamesPage clickToysNGames(){
        toysGamesTab.click();
        return new ToysGamesPage();
    }

    public void checkCart(){
        String actual= driver.findElement(By.xpath("//h2[normalize-space()='Your Amazon Cart is empty']")).getText();
        String expected= "Your Amazon Cart is empty";
        cartButton.click();
        Assert.assertEquals(actual,expected);


    }




public static void main(String[] args){


}



}
