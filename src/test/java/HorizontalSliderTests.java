import base.BaseTest;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class HorizontalSliderTests extends BaseTest {

    @Feature(value = "Horizontal Slider")
    @Test
    public void sliderTest() {

        var horizontalSliderPage = homePage.clickHorizontalSliders();

        String value = "3.5";
        horizontalSliderPage.setSliderTo(value);
        String sliderValue = horizontalSliderPage.getSliderValue();
        assertEquals(value, sliderValue, "Value is not correct. It is " + sliderValue);
    }
}
