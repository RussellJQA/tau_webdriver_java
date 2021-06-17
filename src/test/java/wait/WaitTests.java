package wait;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.DynamicLoadingExample1Page;

import static org.testng.Assert.assertEquals;

public class WaitTests extends BaseTests {

    @Test
    public void testWaitUntilHidden() {
        DynamicLoadingExample1Page loadingPage = homePage.clickDynamicLoading().clickExample1();
        loadingPage.clickStart();
        assertEquals(loadingPage.getLoadedText(), "Hello World!", "Loaded text incorrect");
    }
}