package exercises.chapter7.contextmenu;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ContextMenuPage;

import static org.testng.Assert.assertEquals;

public class ContextMenuTests extends BaseTests {

    @Test
    public void testContextMenu() {
        ContextMenuPage contextMenuPage = homePage.clickContextMenu();
        contextMenuPage.rightClickHotSpot();
        String text = contextMenuPage.alert_GetText();
        contextMenuPage.alert_clickToAccept();
        assertEquals(text, "You selected a context menu", "Alert text incorrect");
    }
}