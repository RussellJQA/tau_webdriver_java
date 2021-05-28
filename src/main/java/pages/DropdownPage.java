package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage {

    private WebDriver driver;
    private final By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectFromDropDown(String option) {
        findDropDownElement().selectByVisibleText(option);
    }

    public List<String> getSelectOptions() {
        List<WebElement> selectedElements =
                findDropDownElement().getAllSelectedOptions();

        // For each selected dropdown element, get its text, then collect all into a list
        /* return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList()); */
        return selectedElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    private Select findDropDownElement() {
        return new Select(driver.findElement(dropdown));
    }
}