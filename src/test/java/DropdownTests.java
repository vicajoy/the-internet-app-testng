import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class DropdownTests extends BaseTests {

    @Test
    public void testSelectOptionFromDropdown() {

        var dropdownPage = homePage.clickDropdown();
        Assert.assertEquals(dropdownPage.getCurrentUrl(), dropdownPage.getPageUrl());

        String option = "Option 1";
        dropdownPage.selectOption(option);
        var selectedOptions = dropdownPage.getSelectedOptions();
        Assert.assertEquals(selectedOptions.size(), 1, "Incorrect number of selections.");
        Assert.assertTrue(selectedOptions.contains(option), "Option is not selected.");
    }

    @Test
    public void testAddMultipleAttributeToDropdown() {

        var dropdownPage = homePage.clickDropdown();
        dropdownPage.addMultipleAttribute();

        var optionsToSelect = List.of("Option 1", "Option 2");
        optionsToSelect.forEach(dropdownPage::selectOption);

        var selectedOptions = dropdownPage.getSelectedOptions();
        Assert.assertTrue(selectedOptions.containsAll(optionsToSelect), "All options are not selected.");
        Assert.assertEquals(selectedOptions.size(), optionsToSelect.size(), "Incorrect number of selected items.");
    }
}
