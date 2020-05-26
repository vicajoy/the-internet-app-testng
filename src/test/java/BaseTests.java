import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.HomePage;


public class BaseTests {

    protected WebDriver driver;
    protected HomePage homePage;

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser) {
        DriverFactory factory = new DriverFactory(browser);
        driver = factory.createDriver();
        goHome();
    }

    public void goHome() {
        driver.get("https://the-internet.herokuapp.com");
        homePage = new HomePage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
