package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.BaseTest;
import utilities.Driver;

import java.time.Duration;

public class FacebookTest extends BaseTest {

    WebDriverWait wait;


    @Test (groups = {"smoke", "E2E"})
    public void facebookNegatifLogintesti() throws InterruptedException {
        //1 - https://www.facebook.com/ adresine gidin
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        Driver.getDriver().get("https://www.facebook.com/");

        //2- Cookies cikiyorsa kabul edin
        FacebookPage facebookPage = new FacebookPage();
        wait.until(ExpectedConditions.elementToBeClickable(facebookPage.cookiesKabulButonu));

        facebookPage.cookiesKabulButonu
                .click();

        //3- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin
        //4- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin

        Faker faker = new Faker();

        facebookPage.loginSayfasiEmailKutusu.sendKeys(faker.internet().emailAddress());
        facebookPage.loginSayfasiPasswordKutusu.sendKeys(faker.internet().password());

        facebookPage.loginSayfasiLoginButonu.click();

        //5- Basarili giris yapilamadigini test edin

        Assert.assertTrue( facebookPage.loginSayfasiEmailKutusu.isDisplayed());

       // Driver.closeDriver();

    }
}