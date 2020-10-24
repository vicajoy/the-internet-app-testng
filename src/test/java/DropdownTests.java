import static org.testng.Assert.*;

import base.BaseTest;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import java.util.List;

public class DropdownTests extends BaseTest {

    @Feature(value = "Dropdowns")
    @Test
    public void testSelectOptionFromDropdown() {

        var dropdownPage = homePage.clickDropdown();

        String option = "Option 1";
        dropdownPage.selectOption(option);
        var selectedOptions = dropdownPage.getSelectedOptions();
        assertEquals(selectedOptions.size(), 1, "Incorrect number of selections.");
        assertTrue(selectedOptions.contains(option), "Option is not selected.");
    }

    @Feature(value = "Dropdowns")
    @Test
    public void testAddMultipleAttributeToDropdown() {

        var dropdownPage = homePage.clickDropdown();
        dropdownPage.addMultipleAttribute();

        var optionsToSelect = List.of("Option 1", "Option 2");
        optionsToSelect.forEach(dropdownPage::selectOption);

        var selectedOptions = dropdownPage.getSelectedOptions();
        assertTrue(selectedOptions.containsAll(optionsToSelect), "All options are not selected.");
        assertEquals(selectedOptions.size(), optionsToSelect.size(), "Incorrect number of selected items.");
    }
}
