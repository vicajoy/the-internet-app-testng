import static org.testng.Assert.*;

import base.BaseTest;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

public class MultipleWindowsTests extends BaseTest {

    @Feature(value = "Multiple Windows")
    @Test
    public void newWindowTest() {

        var windowsPage = homePage.clickMultipleWindows();
        windowsPage.clickHere();
        var newWindowPage = windowsPage.switchToWindowByTitle("New Window");
        String currentPageTitle = newWindowPage.getPageTitle();
        assertTrue(currentPageTitle.contains("New Window"), "New page title doesn't contain the expected text");
    }
}
