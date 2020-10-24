import base.BaseTest;
import io.qameta.allure.Feature;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class KeysTests extends BaseTest {

    @Feature(value = "Keys")
    @Test
    public void testBackspace() {
        var keyPage = homePage.clickKeyPresses();
        keyPage.enterText("A" + Keys.BACK_SPACE);
        assertEquals(keyPage.getResult(), "You entered: BACK_SPACE", "Input result incorrect");
    }
}
