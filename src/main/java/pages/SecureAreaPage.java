package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePage {

    private String url = "https://the-internet.herokuapp.com/secure";
    private By statusAlert = By.cssSelector("#flash");
    private By logOutButton = By.cssSelector("[class='button secondary radius']");

    public SecureAreaPage(WebDriver driver) {
        super(driver);
    }

    public String getAlertText(){
        return getText(statusAlert);
    }

    public String getPageUrl(){
        return url;
    }

    public Boolean isLogoutButtonVisible() {
        return find(logOutButton).isDisplayed();
    }
}
