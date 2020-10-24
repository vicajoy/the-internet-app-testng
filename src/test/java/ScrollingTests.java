import base.BaseTest;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class ScrollingTests extends BaseTest {

    @Feature(value = "Scrolling")
    @Test
    public void testScrollToTable() {
        var largeAndDeepDom = homePage.clickLargeAndDeepDom();
        largeAndDeepDom.scrollToTable();
        assertEquals(largeAndDeepDom.getTableTitle(), "Table", "Table title is incorrect.");
    }

    @Feature(value = "Scrolling")
    @Test
    public void testScrollToFifthParagraph() {
        var infiniteScrollPage = homePage.clickInfiniteScroll();
        infiniteScrollPage.scrollToParagraph(5);
    }
}
