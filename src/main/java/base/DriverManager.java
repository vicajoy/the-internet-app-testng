package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;


public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public DriverManager() {
    }

    public WebDriver createInstance(String browser) {
        WebDriver driverInstance;
        DriverManagerType driverManagerType = DriverManagerType.valueOf(browser.toUpperCase());
        WebDriverManager.getInstance(driverManagerType).setup();

        switch (driverManagerType) {
            case CHROME:
                driverInstance = new ChromeDriver();
                break;
            case FIREFOX:
                driverInstance = new FirefoxDriver();
                break;
            case OPERA:
                driverInstance = new OperaDriver();
                break;
            case EDGE:
                driverInstance = new EdgeDriver();
                break;
            case IEXPLORER:
                driverInstance = new InternetExplorerDriver();
                break;
            case SAFARI:
                driverInstance = new SafariDriver();
                break;
            default:
                throw new IllegalArgumentException(driverManagerType.toString());
        }

        return driverInstance;
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver.set(driver);
    }

    public static void quit() {
        DriverManager.driver.get().quit();
        driver.remove();
    }
}
