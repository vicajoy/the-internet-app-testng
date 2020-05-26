import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTests extends BaseTests {

	@Test
	public void checkboxesTests() {

		var checkboxesPage = homePage.clickCheckboxes();
		Assert.assertEquals(checkboxesPage.getCurrentUrl(), checkboxesPage.getPageUrl());
		checkboxesPage.selectAllCheckboxes();
		Assert.assertTrue(checkboxesPage.areAllCheckboxesChecked(), "Not all checkboxes are checked.");
		checkboxesPage.deselectCheckbox(2);
		Assert.assertFalse(checkboxesPage.isCheckboxesChecked(2), "The checkbox is checked.");
	}
}
