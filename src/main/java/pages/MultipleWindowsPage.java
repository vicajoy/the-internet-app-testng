package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultipleWindowsPage extends Page {

    private By clickHereLink = By.linkText("Click Here");

    public MultipleWindowsPage(WebDriver driver) {
        super(driver);
    }

    /** Clicks the 'Click Here' link on the page */
    public void clickHere() {
        click(clickHereLink);
    }

    /**
     * Switches to a window by its title
     * @param windowTitle  String - the title of the window
     * @return             MultipleWindowsPage
     */
    public MultipleWindowsPage switchToWindowByTitle(String windowTitle) {
        var windows = driver.getWindowHandles();
        for (String window : windows) {
            driver.switchTo().window(window);
            if (windowTitle.equals(getPageTitle())) {
                break;
            }
        }
        return new MultipleWindowsPage(driver);
    }
}