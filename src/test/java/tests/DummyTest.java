package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.dummyPage;
import utilities.BaseTest;
import utilities.ConfigReader;

public class DummyTest extends BaseTest {

    @Parameters("browser")
    @Test (groups = {"E2E", "regression"})
    public void testDummy(){

        //Amazon.com'a git ... degisiklik

        getDriver().get(ConfigReader.getProperty("toUrl"));

        //SearchBox'a eski radio yazdir

        dummyPage dummyPage = new dummyPage();

        dummyPage.aranacakKelimeyiYazVeGonder();

        // Driver.closeDriver();

    }


}
