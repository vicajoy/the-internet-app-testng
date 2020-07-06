import static org.testng.Assert.*;

import base.DataProviders;
import org.testng.annotations.Test;


public class LoginTestsNegative extends DataProviders {

	@Test(dataProvider = "loginData")
	public void loginTestsNegative(String username, String password, String expectedErrorMessage) {

		var loginPage = homePage.clickFormAuthentication();
		var secureAreaPage = loginPage.login(username, password);
		assertTrue(secureAreaPage.getAlertText().contains(expectedErrorMessage),
				"Alert text is incorrect.");
	}
}
