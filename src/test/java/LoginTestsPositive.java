import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestsPositive extends BaseTests {

	@Test
	public void loginTestsPositive() {

		var loginPage = homePage.clickFormAuthentication();
		var secureAreaPage = loginPage.login("tomsmith", "SuperSecretPassword!");
		Assert.assertTrue(secureAreaPage.getAlertText().contains("You logged into a secure area!"),
				"Alert text is incorrect.");
		Assert.assertEquals(secureAreaPage.getCurrentUrl(), secureAreaPage.getPageUrl());
		Assert.assertTrue(secureAreaPage.isLogoutButtonVisible(), "Logout button is not visible.");
	}
}
