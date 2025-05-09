package utilities;

import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.Driver;



public class BaseTest extends Driver {

        @BeforeMethod(alwaysRun = true)
        public void setupBrowser(ITestContext context) {
            String browser = context.getCurrentXmlTest().getParameter("browser");
            Driver.setBrowser(browser); // Driver’a parametreyi set et
        }

        @AfterMethod(alwaysRun = true)
        public void tearDown(){
                if (driverThread.get() != null) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    driverThread.get().quit();
                    driverThread.remove();
                    browserThread.remove();
                }
            }
        }


