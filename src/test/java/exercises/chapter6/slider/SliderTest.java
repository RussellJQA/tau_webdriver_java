package exercises.chapter6.slider;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.SliderPage;

import static org.testng.Assert.assertEquals;

public class SliderTest extends BaseTests {

    @Test
    public void testSlideSliderTo4() {
        SliderPage sliderPage = homePage.clickHorizontalSlider();
        sliderPage.setSliderValue(4);
        assertEquals(sliderPage.getSliderValue(), "4");
    }
}