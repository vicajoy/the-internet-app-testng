import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class LoginTestsPositive extends BaseTests {

	@Test
	public void loginTestsPositive() {

		var loginPage = homePage.clickFormAuthentication();
		var secureAreaPage = loginPage.login("tomsmith", "SuperSecretPassword!");
		assertTrue(secureAreaPage.getAlertText().contains("You logged into a secure area!"),
				"Alert text is incorrect.");
		assertEquals(secureAreaPage.getCurrentUrl(), secureAreaPage.getPageUrl());
		assertTrue(secureAreaPage.isLogoutButtonVisible(), "Logout button is not visible.");
	}
}
