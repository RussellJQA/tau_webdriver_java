package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

        private WebDriver driver;
        private final By formAuthenticationLink = By.linkText("Form Authentication");

        public HomePage(WebDriver driver) { this.driver = driver; }

        public LoginPage clickFormAuthenticationLink() {
            driver.findElement(formAuthenticationLink).click();
            return new LoginPage(driver);
        }
}