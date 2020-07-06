package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public abstract class Page {

    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Finds element using given locator
     * @param index    int - starts at 1
     * @param locator  By - locator to find the element
     * @return		   WebElement - element found by index
     */
    protected WebElement find(By locator, int index) {
        return driver.findElements(locator).get(index - 1);
    }

    /**
     * Finds the first element using given locator
     * @param locator  By - locator to find the element
     * @return		   WebElement - first element found
     */
    protected WebElement find(By locator) {
        return driver.findElements(locator).get(0);
    }

    /**
     * Finds all elements using given locator
     * @param locator  By - locator to find the element
     * @return		   List - all the elements found
     */
    protected List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

    /**
     * Clicks on element with given index when it's visible
     * @param index    int - starts at 1
     * @param locator  By - locator to find the element
     */
    protected void click(By locator, int index) {
        waitForVisibilityOf(locator, 5);
        find(locator, index).click();
    }

    /**
     * Clicks on the first element with given locator when it's visible
     * @param locator  By - locator to find the element
     */
    protected void click(By locator) {
        waitForVisibilityOf(locator, 5);
        find(locator).click();
    }

    /**
     * Types given text into element with given locator
     * @param text     String - text to enter into the element
     * @param locator  By - locator to find the element
     */
    protected void type(String text, By locator) {
        waitForVisibilityOf(locator, 5);
        find(locator).sendKeys(text);
    }

    /**
     * Waits for specific ExpectedCondition for the given amount of time in seconds
     * @param condition         condition for WebElement to wait for
     * @param timeOutInSeconds  int - number of seconds to wait for the condition
     */
    private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
        timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(condition);
    }

    /**
     * Waits for given number of seconds for the element with given locator to be visible
     * @param locator           By - locator for the element
     * @param timeOutInSeconds  int - number of seconds to wait for the condition
     */
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

    /**
     * Gets element text with given locator when it's visible
     * @param locator  By - locator for the element
     * @return		   String - text of the element
     */
    protected String getText(By locator) {
        waitForVisibilityOf(locator, 5);
        return find(locator).getText();
    }

    /** Waits for alert to be present and then switch to it
     * @return		   Alert - the alert to work with
     */
    protected Alert switchToAlert() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }

    /** Gets the current page title
     * @return		   String - the page title
     */
    public String getPageTitle() {
        return driver.getTitle();
    }

    /** Presses Key on the element
     * @param locator  By - locator for the element
     */
    protected void pressKey(By locator, Keys key) {
        find(locator).sendKeys(key);
    }
}
