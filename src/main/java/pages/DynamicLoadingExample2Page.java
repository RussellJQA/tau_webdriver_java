package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingExample2Page {

    private WebDriver driver;

    private final static By startButton = By.cssSelector("#start button");
    private final static By loadedText = By.id("finish");

    public DynamicLoadingExample2Page(WebDriver driver) { this.driver = driver; }

    public void clickStart() { driver.findElement(startButton).click(); }

    public void waitForText(String text) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated((loadedText)));
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(loadedText), text));
    }

    public String getLoadedText() {
        return driver.findElement(loadedText).getText();
    }
}