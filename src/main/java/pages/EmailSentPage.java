package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Because of a Known Issue on the Web site, I couldn't examine the expected Web page manually in order to
 * determine how to implement this class.
 * <p>
 * So, for now, I instead just copied it from the course repository at
 * https://raw.githubusercontent.com/angiejones/selenium-webdriver-java-course/master/webdriver_java/src/main/java/pages/EmailSentPage.java
 */

public class EmailSentPage {

    private static final By messageArea = By.id("content");
    private final WebDriver driver;

    public EmailSentPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getMessage() {
        return driver.findElement(messageArea).getText();
    }
}