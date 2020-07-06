package base;
import org.testng.annotations.DataProvider;

public class DataProviders extends BaseTest {

    @DataProvider(name = "files")
    protected static Object[][] files() {
        return new Object[][] {
                {"java.jpg"},
                {"circle.png"},
                {"sample.pdf"}
        };
    }

    @DataProvider(name = "loginData")
    protected static Object[][] loginData() {
        return new Object[][] {
                {"incorrectUsername", "SuperSecretPassword!", "Your username is invalid!"},
                {"tomsmith", "incorrectPassword", "Your password is invalid!"}
        };
    }
}
