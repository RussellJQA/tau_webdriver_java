package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DynamicLoadingPage{

    private WebDriver driver;

    private String linkXpath_Format = "//a[contains(text(), '%s')]";
    private final By link_example1 = By.xpath((String.format(linkXpath_Format, "Example 1")));
    private final By link_example2= By.xpath((String.format(linkXpath_Format, "Example 2")));
    private static final By startButton = By.id("start");

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }

    public DynamicLoadingExample1Page clickExample1() {
        driver.findElement(link_example1).click();
        return new DynamicLoadingExample1Page(driver);
    }

    public DynamicLoadingExample2Page clickExample2() {
        driver.findElement(link_example2).click();
        return new DynamicLoadingExample2Page(driver);
    }

    // Although the assignment talks about right-clicking, what's actually needed is Ctrl+Click
    public DynamicLoadingExample2Page ctrlClickExample2() {

        // Ctrl+Click to open Example2
        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).build().perform();
        driver.findElement(link_example2).click();
        action.keyUp(Keys.CONTROL).build().perform();

        return new DynamicLoadingExample2Page(driver);
    }
}