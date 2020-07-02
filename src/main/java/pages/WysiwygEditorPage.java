package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwygEditorPage extends Page {

    private String editorIFrameId = "mce_0_ifr";
    private By textArea = By.id("tinymce");
    private By decreaseIndentButton = By.cssSelector("#mceu_12 button");

    public WysiwygEditorPage(WebDriver driver) {
        super(driver);
    }

    /** Clears text from the area */
    public void clearTextArea() {
        switchToEditArea();
        find(textArea).clear();
        switchToMainArea();
    }

    /**
     * Enters text into the area
     * @param text  String - text to be entered
     */
    public void enterTextToEditor(String text) {
        switchToEditArea();
        type(text, textArea);
        switchToMainArea();
    }

    /**
     * Gets the entered text from the area
     * @return             String - text from the area
     */
    public String getTextFromEditor() {
        switchToEditArea();
        String text = getText(textArea);
        switchToMainArea();
        return text;
    }

    /** Decreases the text indention */
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
