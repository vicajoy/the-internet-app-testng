package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwygEditorPage extends BasePage {

    private String editorIFrameId = "mce_0_ifr";
    private By textArea = By.id("tinymce");
    private By decreaseIndentButton = By.cssSelector("#mceu_12 button");

    public WysiwygEditorPage(WebDriver driver){
        super(driver);
    }

    public void clearTextArea() {
        switchToEditArea();
        find(textArea).clear();
        switchToMainArea();
    }

    public void enterTextToEditor(String text) {
        switchToEditArea();
        type(text, textArea);
        switchToMainArea();
    }

    public String getTextFromEditor() {
        switchToEditArea();
        String text = getText(textArea);
        switchToMainArea();
        return text;
    }

    public void decreaseIndention() {
        click(decreaseIndentButton);
    }

    private void switchToEditArea() {
        driver.switchTo().frame(editorIFrameId);
    }

    private void switchToMainArea() {
        driver.switchTo().parentFrame();
    }
}
