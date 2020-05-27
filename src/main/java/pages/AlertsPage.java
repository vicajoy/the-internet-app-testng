package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage extends BasePage {

    private By triggerJSAlertButton = By.xpath(".//button[text()='Click for JS Alert']");
    private By triggerJSConfirmButton = By.xpath(".//button[text()='Click for JS Confirm']");
    private By triggerJSPromptButton = By.xpath(".//button[text()='Click for JS Prompt']");
    private By results = By.id("result");

    public AlertsPage(WebDriver driver){
        super(driver);
    }

    public void triggerJSAlert() {
        click(triggerJSAlertButton);
    }

    public void triggerJSConfirm() {
        click(triggerJSConfirmButton);
    }

    public void triggerJSPrompt() {
        click(triggerJSPromptButton);
    }

    public void acceptAlert() {
        Alert alert = switchToAlert();
        alert.accept();
    }

    public void dismissAlert() {
        Alert alert = switchToAlert();
        alert.dismiss();
    }

    public String getAlertText() {
        Alert alert = switchToAlert();
        return alert.getText();
    }

    public void enterAlertText(String text) {
        Alert alert = switchToAlert();
        alert.sendKeys(text);
    }

    public String getResult() {
        return getText(results);
    }
}
