package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoversPage extends Page {

    private By figureBox = By.className("figure");
    private By boxCaption = By.className("figcaption");

    public HoversPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Moves slider to specified value
     * @param index      int - index of the figure, starts at 1
     * @return           FigureCaption
     */
    public FigureCaption hoverOverFigure(int index) {
        WebElement figure = findAll(figureBox).get(index - 1);
        Actions actions = new Actions(driver);
        actions.moveToElement(figure).perform();
        return new FigureCaption(figure.findElement(boxCaption));
    }

    public class FigureCaption {

        private WebElement caption;
        private By header = By.tagName("h5");
        private By link = By.tagName("a");

        public FigureCaption(WebElement caption) {
            this.caption = caption;
        }

        /**
         * Checks whether caption is displayed
         * @return           boolean - true is displayed, false otherwise
         */
        public boolean isCaptionDisplayed() {
            return caption.isDisplayed();
        }

        /**
         * Gets caption title
         * @return           String - text of caption header
         */
        public String getTitle() {
            return caption.findElement(header).getText();
        }

        /**
         * Gets caption link value
         * @return           String - caption link value
         */
        public String getLink() {
            return caption.findElement(link).getAttribute("href");
        }

        /**
         * Gets caption link text
         * @return           String - caption link text
         */
        public String getLinkText() {
            return caption.findElement(link).getText();
        }
    }
}
