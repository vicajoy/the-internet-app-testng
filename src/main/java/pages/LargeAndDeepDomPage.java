package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LargeAndDeepDomPage extends Page {

    private By table = By.id("large-table");
    private By title = By.tagName("h4");

    public LargeAndDeepDomPage(WebDriver driver) {
        super(driver);
    }

    /** Scrolls to the table on the page */
    public void scrollToTable() {
        WebElement tableElement = find(table);
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(script, tableElement);
    }

    /**
     * Gets the table title
     * @return          String - table title
     */
    public String getTableTitle() {
        return find(title, 3).getText();
    }
}
