package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
This class was copied verbatim from
https://raw.githubusercontent.com/angiejones/selenium-webdriver-java-course/master/webdriver_java/src/main/java/pages/EmailSentPage.java
because currently (May 26, 2021) clicking Forgot Password's "Retrieve password" button gives an "Internal Server Error".
 */
public class EmailSentPage {

    private WebDriver driver;
    private By contentArea = By.id("content");

    public EmailSentPage(WebDriver driver){
        this.driver = driver;
    }

    public String getMessage() {
        return driver.findElement(contentArea).getText();
    }
}