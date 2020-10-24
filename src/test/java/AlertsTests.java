import static org.testng.Assert.*;

import base.BaseTest;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

public class AlertsTests extends BaseTest {

    @Feature(value = "Alerts")
    @Test
    public void testAcceptAlert(){
        var alertsPage = homePage.clickJavascriptAlerts();
        alertsPage.triggerJSAlert();
        alertsPage.acceptAlert();
        assertEquals(alertsPage.getResult(), "You successfuly clicked an alert",
                "Results text is incorrect.");
    }

    @Feature(value = "Alerts")
    @Test
    public void testGetAlertText(){
        var alertsPage = homePage.clickJavascriptAlerts();
        alertsPage.triggerJSConfirm();
        String text = alertsPage.getAlertText();
        alertsPage.dismissAlert();
        assertEquals(text, "I am a JS Confirm", "Alert text is incorrect.");
    }

    @Test
    public void testEnterAlertText(){
        var alertsPage = homePage.clickJavascriptAlerts();
        alertsPage.triggerJSPrompt();
        String text = "Hello!";
        alertsPage.enterAlertText(text);
        alertsPage.acceptAlert();
        assertEquals(alertsPage.getResult(), "You entered: " + text, "Results text is incorrect.");
    }
}
