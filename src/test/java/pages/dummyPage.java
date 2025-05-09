package pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class dummyPage {

    public dummyPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "twotabsearchtextbox")
    private WebElement amazonSearchBox ;

    @FindBy(id = "nav-search-submit-button")
    private WebElement amazonAramaButonu;


    public void aranacakKelimeyiYazVeGonder(){

        amazonSearchBox.sendKeys(ConfigReader.getProperty("searchWord")+Keys.ENTER);

    }


}




