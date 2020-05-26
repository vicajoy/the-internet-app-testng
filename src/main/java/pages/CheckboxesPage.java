package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CheckboxesPage extends BasePage {

    private String url = "https://the-internet.herokuapp.com/checkboxes";
    private By checkbox = By.cssSelector("#checkboxes input");

    public CheckboxesPage(WebDriver driver) {
        super(driver);
    }

    public String getPageUrl(){
        return url;
    }

    public void deselectCheckbox(Integer index){
        WebElement currentCheckbox = find(checkbox, index);
        if (currentCheckbox.isSelected()) {
            currentCheckbox.click();
        }
    }

    /** Verify checkbox is checked */
    public boolean isCheckboxesChecked(Integer index) {
        WebElement currentCheckbox = find(checkbox, index);
        return currentCheckbox.isSelected();
    }

    /** Verify all available checkboxes are checked. If not, select them */
    public void selectAllCheckboxes() {
        List<WebElement> checkboxes = findAll(checkbox);
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }

    /** Verify all available checkboxes are checked. If at least one unchecked, return false */
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
