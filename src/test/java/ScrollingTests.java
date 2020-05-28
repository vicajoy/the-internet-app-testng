import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ScrollingTests extends BaseTests {

    @Test
    public void testScrollToTable() {
        var largeAndDeepDom = homePage.clickLargeAndDeepDom();
        largeAndDeepDom.scrollToTable();
        assertEquals(largeAndDeepDom.getTableTitle(), "Table", "Table title is incorrect.");
    }

    @Test
    public void testScrollToFifthParagraph() {
        var infiniteScrollPage = homePage.clickInfiniteScroll();
        infiniteScrollPage.scrollToParagraph(5);
    }
}
