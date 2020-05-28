package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage extends BasePage {

    private By rangeLocator = By.id("range");
    private By sliderLocator = By.tagName("input");

    public HorizontalSliderPage(WebDriver driver) {
        super(driver);
    }

    /** Move slider to specified value */
    public void setSliderTo(String value) {
        int steps = (int) (Double.parseDouble(value) / 0.5);
        pressKey(sliderLocator, Keys.ENTER);
        for (int i = 0; i < steps; i++) {
            pressKey(sliderLocator, Keys.ARROW_RIGHT);
        }
    }

    /** Getting slider value */
    public String getSliderValue() {
        return getText(rangeLocator);
    }
}
