package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage {

    private static final String topFrame = "frame-top";  // For finding a frame with a name="frame-top"
    private static final String bottomFrame = "frame-bottom";
    private static final String leftFrame = "frame-left";
    private static final By body = By.tagName("body");
    private final WebDriver driver;

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