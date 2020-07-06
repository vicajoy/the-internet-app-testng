import base.BaseTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class WysiwygEditorPageTests extends BaseTest {

    @Test
    public void testWysiwygEditor(){
        var editorPage = homePage.clickWysiwygEditor();
        editorPage.clearTextArea();

        String text1 = "hello ";
        String text2 = "world";

        editorPage.enterTextToEditor(text1);
        editorPage.decreaseIndention();
        editorPage.enterTextToEditor(text2);
        assertEquals(editorPage.getTextFromEditor(), text1+text2, "Text from editor is incorrect.");
    }
}
