package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage extends Page {

    private By triggerJSAlertButton = By.xpath(".//button[text()='Click for JS Alert']");
    private By triggerJSConfirmButton = By.xpath(".//button[text()='Click for JS Confirm']");
    private By triggerJSPromptButton = By.xpath(".//button[text()='Click for JS Prompt']");
    private By results = By.id("result");

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    /** Clicks "Click for JS Alert" button */
    public void triggerJSAlert() {
        click(triggerJSAlertButton);
    }

    /** Clicks "Click for JS Confirm" button */
    public void triggerJSConfirm() {
        click(triggerJSConfirmButton);
    }

    /** Clicks "Click for JS Prompt" button */
    public void triggerJSPrompt() {
        click(triggerJSPromptButton);
    }

    /** Accepts an alert */
    public void acceptAlert() {
        Alert alert = switchToAlert();
        alert.accept();
    }

    /** Dismisses an alert */
    public void dismissAlert() {
        Alert alert = switchToAlert();
        alert.dismiss();
    }

    /**
     * Gets the alert text
     * @return String - text from the alert
     */
    public String getAlertText() {
        Alert alert = switchToAlert();
        return alert.getText();
    }

    /**
     * Enters text to the alert
     * @param text    String - text to be entered
     */
    public void enterAlertText(String text) {
        Alert alert = switchToAlert();
        alert.sendKeys(text);
    }

    /**
     * Gets the text of the result after clicking one of the buttons
     * @return String - text from the result
     */
    public String getResult() {
        return getText(results);
    }
}
