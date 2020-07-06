import static org.testng.Assert.*;

import base.BaseTest;
import org.testng.annotations.Test;

public class MultipleWindowsTests extends BaseTest {

    @Test
    public void newWindowTest() {

        var windowsPage = homePage.clickMultipleWindows();
        windowsPage.clickHere();
        var newWindowPage = windowsPage.switchToWindowByTitle("New Window");
        String currentPageTitle = newWindowPage.getPageTitle();
        assertTrue(currentPageTitle.contains("New Window"), "New page title doesn't contain the expected text");
    }
}
