package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void openUrl(String url) {
        driver.get(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /** Find element using given locator
     * @param index starts at 1
     * */
    protected WebElement find(By locator, Integer index) {
        return driver.findElements(locator).get(index - 1);
    }

    /** Find element using given locator with default index */
    protected WebElement find(By locator) {
        return driver.findElements(locator).get(0);
    }

    /** Find all elements using given locator */
    protected List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

    /** Click on element with given locator when it's visible */
    protected void click(By locator) {
        waitForVisibilityOf(locator, 5);
        find(locator).click();
    }

    /** Type given text into element with given locator */
    protected void type(String text, By locator) {
        waitForVisibilityOf(locator, 5);
        find(locator).sendKeys(text);
    }

    /** Wait for specific ExpectedCondition for the given amount of time in seconds */
    private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
        timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(condition);
    }

    /** Wait for given number of seconds for element with given locator to be visible */
    protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                        (timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
    }

    /** Get element text with given locator when it's visible */
    protected String getText(By locator) {
        waitForVisibilityOf(locator, 5);
        return find(locator).getText();
    }

}
