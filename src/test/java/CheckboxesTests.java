import org.testng.annotations.Test;
import static org.testng.Assert.*;
public class CheckboxesTests extends BaseTests {

	@Test
	public void checkboxesTests() {

		var checkboxesPage = homePage.clickCheckboxes();
		assertEquals(checkboxesPage.getCurrentUrl(), checkboxesPage.getPageUrl());
		checkboxesPage.selectAllCheckboxes();
		assertTrue(checkboxesPage.areAllCheckboxesChecked(), "Not all checkboxes are checked.");
		checkboxesPage.deselectCheckbox(2);
		assertFalse(checkboxesPage.isCheckboxesChecked(2), "The checkbox is checked.");
	}
}
