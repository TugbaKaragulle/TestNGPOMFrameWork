package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SauceDemoLoginPage;
import utilities.BaseTest;
import utilities.Driver;

import static utilities.Driver.getDriver;

public class SouceDemoLoginTest extends BaseTest {

    @Test (groups = {"smoke","regression"})
    public void pageFactoryTest() {
        SauceDemoLoginPage saucepage = new SauceDemoLoginPage();
        //Navigate to https://www.saucedemo.com/
        getDriver().get("https://www.saucedemo.com/");

        //Enter the username as standard_user
        saucepage.fillNameField("standard_user");

        //Enter the password as secret_sauce
        saucepage.fillPasswordField("secret_sauce");

        //Click on login button.
        saucepage.clickSubmitButton();

        Driver.closeDriver();
    }


@Test (groups = "regression")
    public void pageFactoryTest2() {
        SauceDemoLoginPage saucepage = new SauceDemoLoginPage();
        //Navigate to https://www.saucedemo.com/
        getDriver().get("https://www.saucedemo.com/");

        //Enter the username as standard_user
        saucepage.fillNameField("standard_user");

        //Enter the password as secret_sauce
        saucepage.fillPasswordField("secret_sauce");

        //Click on login button.
        saucepage.clickSubmitButton();

       // Driver.closeDriver();
    }
}
