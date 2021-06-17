package exercises.chapter10.javascript;

import base.BaseTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.DropDownPage;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JavaScriptTests extends BaseTests {

    private WebDriver driver;

    @Test
    public void testMultipleOptions() {
        DropDownPage dropDownPage = homePage.clickDropDown();
        dropDownPage.setMultipleOptions();

        String option1 = "Option 1";
        dropDownPage.selectFromDropDown(option1);
        String option2 = "Option 2";
        dropDownPage.selectFromDropDown(option2);

        List<String> selectedOptions = dropDownPage.getSelectOptions();
        assertEquals(selectedOptions.size(), 2, "Incorrect number of selections");
        assertTrue(selectedOptions.contains(option1), "Option 1 not selected");
        assertTrue(selectedOptions.contains(option2), "Option 2 not selected");
    }
}