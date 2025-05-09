package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static utilities.Driver.getDriver;

public class SauceDemoLoginPage {


    // Locatorlar -> @FindBy
    @FindBy(id = "user-name")
    public WebElement userName;
    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "login-button")
    public WebElement submitButton;

    // Constructor içerisinde PageFactory.initElements(driver,this);

    public SauceDemoLoginPage() {
        PageFactory.initElements(getDriver(),this);
    }


    // Web saydasında elementler ile ilgili methodlar
    public void fillNameField(String name){
        userName.sendKeys(name);
    }

    public void fillPasswordField(String pass){
        password.sendKeys(pass);
    }
    public void clickSubmitButton(){
        submitButton.click();
    }
}

