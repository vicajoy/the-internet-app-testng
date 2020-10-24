import static org.testng.Assert.*;

import base.BaseTest;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

public class LoginTestsPositive extends BaseTest {

	@Feature(value = "Login")
	@Test
	public void loginTestsPositive() {

		var loginPage = homePage.clickFormAuthentication();
		var secureAreaPage = loginPage.login("tomsmith", "SuperSecretPassword!");
		assertTrue(secureAreaPage.getAlertText().contains("You logged into a secure area!"),
				"Alert text is incorrect.");
		assertTrue(secureAreaPage.isLogoutButtonVisible(), "Logout button is not visible.");
	}
}
