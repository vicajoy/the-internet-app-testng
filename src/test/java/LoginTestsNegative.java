import static org.testng.Assert.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class LoginTestsNegative extends BaseTests {

	@Parameters({ "username", "password", "expectedMessage" })
	@Test(priority = 1)
	public void loginTestsNegative(String username, String password, String expectedErrorMessage) {

		var loginPage = homePage.clickFormAuthentication();
		var secureAreaPage = loginPage.login(username, password);
		assertTrue(secureAreaPage.getAlertText().contains(expectedErrorMessage),
				"Alert text is incorrect.");
	}
}
