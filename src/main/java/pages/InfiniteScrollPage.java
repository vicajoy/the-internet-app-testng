package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScrollPage extends Page {

    By textBlocks = By.className("jscroll-added");

    public InfiniteScrollPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Scrolls until paragraph with index specified
     * @param index     int - index of the paragraph, starts at 1
     */
    public void scrollToParagraph(int index) {
        String script = "window.scrollTo(0, document.body.scrollHeight)";
        var jsExecutor = (JavascriptExecutor)driver;

        while(getNumberOfParagraphsPresent() <= index) {
            jsExecutor.executeScript(script);
        }
    }

    /**
     * Gets the number of displayed paragraphs
     * @return           int - count of displayed paragraphs
     */
    private int getNumberOfParagraphsPresent() {
        return findAll(textBlocks).size();
    }
}
