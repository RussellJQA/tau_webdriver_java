package exercises.chapter9.wait;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.DynamicLoadingExample2Page;

import static org.testng.Assert.assertEquals;

public class WaitTests extends BaseTests {

    @Test
    public void testWaitForText() {
        DynamicLoadingExample2Page loadingPage = homePage.clickDynamicLoading().clickExample2();
        loadingPage.clickStart();
        String text = "Hello World!";
        loadingPage.waitForText(text);
        assertEquals(loadingPage.getLoadedText(), text, "Loaded text incorrect");
    }
}