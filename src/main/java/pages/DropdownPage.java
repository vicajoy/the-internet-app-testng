package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage extends Page {

    private String url = "https://the-internet.herokuapp.com/dropdown";
    private By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Selects dropdown option by text
     * @param option  String - text of the option
     */
    public void selectOption(String option) {
        findDropDownElement().selectByVisibleText(option);
    }

    /**
     * Gets selected options of a dropdown
     * @return       List - list of the selected options
     */
    public List<String> getSelectedOptions() {
        List<WebElement> selectedElements = findDropDownElement().getAllSelectedOptions();
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    /** Adds multiple attribute to the dropdown by JavaScript */
    public void addMultipleAttribute() {
        String script = "arguments[0].setAttribute('multiple','')";
        ((JavascriptExecutor)driver).executeScript(script, findDropDownElement());
    }

    private Select findDropDownElement() {
        return new Select(find(dropdown));
    }

}
