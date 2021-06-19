package exercises.chapter8.nestedFrames;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.NestedFramesPage;

import static org.testng.Assert.assertEquals;

public class NestedFramesTest extends BaseTests {

    @Test
    public void testNestedFrames() {
        NestedFramesPage nestedFramesPage = homePage.clickFrames().clickNestedFrames();

        assertEquals(nestedFramesPage.getTextFromLeftFrame(), "LEFT", "Text from left frame is incorrect");
        assertEquals(nestedFramesPage.getTextFromBottomFrame(), "BOTTOM", "Text from bottom frame is incorrect");
    }
}