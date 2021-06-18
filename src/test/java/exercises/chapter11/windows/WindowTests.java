package exercises.chapter11.windows;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicLoadingExample2Page;

import static org.testng.Assert.assertTrue;

public class WindowTests extends BaseTests {

    @Test
    public void testTabs() {
        String originalTab = getWindowManager().getCurrentWindow();
        DynamicLoadingExample2Page example2Page = homePage.clickDynamicLoading().ctrlClickExample2();
        getWindowManager().switchToOtherTab(originalTab);
        assertTrue(example2Page.isStartButtonDisplayed());
    }
}