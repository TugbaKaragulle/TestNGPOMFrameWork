package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;


    public class Driver {

        public static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();
        public static ThreadLocal<String> browserThread = new ThreadLocal<>();

        public Driver() {}

        public static void setBrowser(String browserName) {
            browserThread.set(browserName);
        }

        public static WebDriver getDriver() {
            if (driverThread.get() == null) {
                String browser = browserThread.get();
                if (browser == null) {
                    browser = ConfigReader.getProperty("browser"); // Fallback: properties dosyasından
                }

                switch (browser.toLowerCase()) {
                    case "edge":
                        driverThread.set(new EdgeDriver());
                        break;
                    case "firefox":
                        driverThread.set(new FirefoxDriver());
                        break;
                    case "headless":
                        driverThread.set(new ChromeDriver(new ChromeOptions().addArguments("--headless")));
                        break;
                    case "chrome":
                    default:
                        driverThread.set(new ChromeDriver());
                }

                getDriver().manage().window().maximize();
                getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            }

            return driverThread.get();
        }

        public static void closeDriver() {
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

