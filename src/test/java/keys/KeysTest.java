package keys;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.KeyPressesPage;

import static org.testng.Assert.assertEquals;

public class KeysTest extends BaseTests {

    @Test
    public void testBackspace() {
        KeyPressesPage keyPage = homePage.clickKeyPresses();
        keyPage.enterText("A" + Keys.BACK_SPACE);
        assertEquals(keyPage.getResponse(), "You entered: BACK_SPACE");
    }

    @Test
    public void testPi() {
        KeyPressesPage keyPage = homePage.clickKeyPresses();
        keyPage.enterPi();

        /* No assert was given in class, so I added this. */
        assertEquals(keyPage.getEnteredText(), "π=3.14");
    }
}