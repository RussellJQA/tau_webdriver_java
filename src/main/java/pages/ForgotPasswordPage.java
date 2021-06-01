package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private WebDriver driver;
    private final By emailField = By.id("email");
    private final By retrievePasswordButton = By.id("form_submit");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public EmailSentPage clickRetrievePasswordButton() {
        driver.findElement(retrievePasswordButton).click();
        return new EmailSentPage(driver);
    }

    // Needed because of Known Issue on the Website Under Test.
    // See comments in ForgotPasswordTests.java
    public String getAlternateText() {
        return driver.findElement(By.tagName("h1")).getText();
    }
}
