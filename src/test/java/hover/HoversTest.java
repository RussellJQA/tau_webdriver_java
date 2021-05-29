package hover;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HoversPage;

import static org.testng.Assert.*;

public class HoversTest extends BaseTests {

    @Test
    public void testHoverUser1() {

        HoversPage hoversPage = homePage.clickHovers();
        HoversPage.FigureCaption caption = hoversPage.hoverOverFigure(1);
        assertTrue(caption.isCaptionDisplayed(), "Caption not displayed");
        assertEquals(caption.getTitle(), "name: user1", "Caption title incorrect");
        assertEquals(caption.getLinkText(), "View profile", "Caption link text incorrect");
        assertTrue(caption.getLink().endsWith("/users/1"), "Caption link incorrect");
    }
}