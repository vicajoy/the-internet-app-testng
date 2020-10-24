import base.BaseTest;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class HoverTests extends BaseTest {

    @Feature(value = "Hover")
    @Test
    public void testHoverUserOne() {
        var hoversPage = homePage.clickHovers();
        var caption = hoversPage.hoverOverFigure(1);
        assertTrue(caption.isCaptionDisplayed(), "Caption is not displayed.");
        assertEquals(caption.getTitle(), "name: user1", "Caption title is incorrect.");
        assertEquals(caption.getLinkText(), "View profile", "Caption link text is incorrect.");
        assertTrue(caption.getLink().endsWith("/users/1"), "Caption link is incorrect.");
    }
}
