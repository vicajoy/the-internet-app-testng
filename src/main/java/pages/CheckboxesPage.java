package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CheckboxesPage extends Page {

    private String url = "https://the-internet.herokuapp.com/checkboxes";
    private By checkbox = By.cssSelector("#checkboxes input");

    public CheckboxesPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Deselects a checkbox if it's checked
     * @param index  int - index for the checkbox
     */
    public void deselectCheckbox(int index) {
        WebElement currentCheckbox = find(checkbox, index);
        if (currentCheckbox.isSelected()) {
            currentCheckbox.click();
        }
    }

    /**
     * Checks whether the checkbox is selected
     * @param index  int - index for the checkbox
     * @return       boolean - true if the checkbox is selected, false otherwise
     */
    public boolean isCheckboxesChecked(int index) {
        WebElement currentCheckbox = find(checkbox, index);
        return currentCheckbox.isSelected();
    }

    /** Selects all the checkboxes */
    public void selectAllCheckboxes() {
        List<WebElement> checkboxes = findAll(checkbox);
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }

    /**
     * Checks whether all checkboxes are selected
     * @return       boolean - true if all checkboxes are selected, false if at least one of them is unchecked
     */
    public boolean areAllCheckboxesChecked() {
        List<WebElement> checkboxes = findAll(checkbox);
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                return false;
            }
        }
        return true;
    }
}
