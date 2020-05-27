package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultipleWindowsPage extends BasePage {

    private By clickHereLink = By.linkText("Click Here");

    public MultipleWindowsPage(WebDriver driver) {
        super(driver);
    }

    public void clickHere() {
        click(clickHereLink);
    }

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