package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends Page {

    private String url = "https://the-internet.herokuapp.com/secure";
    private By statusAlert = By.cssSelector("#flash");
    private By logOutButton = By.cssSelector("[class='button secondary radius']");

    public SecureAreaPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Gets text from the alert bar
     * @return             String - text of alert bar
     */
    public String getAlertText() {
        return getText(statusAlert);
    }

    /**
     * Checks Logout button to be visible
     * @return             boolean - true, if button is visible, false otherwise
     */
    public Boolean isLogoutButtonVisible() {
        return find(logOutButton).isDisplayed();
    }
}
