package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage extends Page {

    private By inputField = By.id("target");
    private By resultText = By.id("result");

    public KeyPressesPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Enters text in the field
     * @param text      String - text to be entered
     */
    public void enterText(String text) {
        type(text, inputField);
    }

    /**
     * Get the result after entering a text
     * @return           String - result text
     */
    public String getResult() {
        return getText(resultText);
    }
}
