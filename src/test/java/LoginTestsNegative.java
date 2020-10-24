import static org.testng.Assert.*;

import base.DataProviders;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;


public class LoginTestsNegative extends DataProviders {

	@Feature(value = "Login")
	@Test(dataProvider = "loginData")
	public void loginTestsNegative(String username, String password, String expectedErrorMessage) {

		var loginPage = homePage.clickFormAuthentication();
		var secureAreaPage = loginPage.login(username, password);
		assertTrue(secureAreaPage.getAlertText().contains(expectedErrorMessage),
				"Alert text is incorrect.");
	}
}
