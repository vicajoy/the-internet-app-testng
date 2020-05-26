package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private By usernameField = By.cssSelector("#username");
    private By passwordField = By.cssSelector("#password");
    private By loginButton = By.cssSelector("#login button");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public SecureAreaPage login(String username, String password){
        type(username, usernameField);
        type(password, passwordField);
        click(loginButton);
        return new SecureAreaPage(driver);
    }
}