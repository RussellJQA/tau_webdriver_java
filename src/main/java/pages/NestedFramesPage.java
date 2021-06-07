package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NestedFramesPage {

    private WebDriver driver;
    private final String topFrame = "frame-top";  // For finding a frame with a name="frame-top"
    private final String bottomFrame = "frame-bottom";
    private final String leftFrame = "frame-left";
    private final By body = By.tagName("body");

    public NestedFramesPage(WebDriver driver) {
        this.driver = driver;
    }

    private String getFrameText() {
         return driver.findElement(body).getText();
    }

    public String getTextFromLeftFrame() {
        driver.switchTo().frame(topFrame);
        driver.switchTo().frame(leftFrame);
        String text = getFrameText();
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        return text;
    }

    public String getTextFromBottomFrame() {
        driver.switchTo().frame(bottomFrame);
        String text = getFrameText();
        driver.switchTo().parentFrame();
        return text;
    }
}