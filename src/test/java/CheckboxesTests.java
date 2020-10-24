import base.BaseTest;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class CheckboxesTests extends BaseTest {

	@Feature(value = "Checkboxes")
	@Test
	public void checkboxesTests() {

		var checkboxesPage = homePage.clickCheckboxes();
		checkboxesPage.selectAllCheckboxes();
		assertTrue(checkboxesPage.areAllCheckboxesChecked(), "Not all checkboxes are checked.");
		checkboxesPage.deselectCheckbox(2);
		assertFalse(checkboxesPage.isCheckboxesChecked(2), "The checkbox is checked.");
	}
}
