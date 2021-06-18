package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingExample2Page {

    private WebDriver driver;

    private static final By startButtonLocator = By.cssSelector("#start button");
    private static final By loadedText = By.id("finish");

    public DynamicLoadingExample2Page(WebDriver driver) { this.driver = driver; }

    public void clickStart() { driver.findElement(startButtonLocator).click(); }

    public void waitForText(String text) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated((loadedText)));
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(loadedText), text));
    }

    public String getLoadedText() {
        return driver.findElement(loadedText).getText();
    }

    public boolean isStartButtonDisplayed() {
        WebElement startButton = driver.findElement(startButtonLocator);
        return startButton.isDisplayed() && startButton.getText().equals("Start");
    }
}