package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ToysGamesPage {

    //@FindBy(how = How.CSS, using = "#search > span.search-text")
    @FindBy(id="#search") //Naveen's way of writing
    public WebElement searchWebElement;

}
