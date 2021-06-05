package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) { this.driver = driver; }

    public DropdownPage clickDropDown() {
        clickLink("Dropdown");
        return new DropdownPage(driver);
    }

    public ForgotPasswordPage clickForgotPassword() {
        clickLink("Forgot Password");
        return new ForgotPasswordPage(driver);
    }

    public LoginPage clickFormAuthentication() {
        clickLink("Form Authentication");
        return new LoginPage(driver);
    }

    public SliderPage clickHorizontalSlider() {
        clickLink("Horizontal Slider");
        return new SliderPage(driver);
    }

    public HoversPage clickHovers() {
        clickLink("Hovers");
        return new HoversPage(driver);
    }

    public AlertsPage clickJavaScripAlerts() {
        clickLink("JavaScript Alerts");
        return new AlertsPage(driver);
    }

    public KeyPressesPage clickKeyPresses() {
        clickLink("Key Presses");
        return new KeyPressesPage(driver);
    }

    private void clickLink(String linkText) {
        WebElement element = driver.findElement(By.linkText(linkText));

        // The following is needed for AlertTests:testAcceptAlert(), possibly due to my upgrading to Chrome 91.
        // Without it, I get
        //      ElementNotInteractableException: element not interactable: element has zero size
        // See https://newbedev.com/elementnotinteractableexception-element-not-interactable-element-has-zero-size-appears-since-upgrade-to-chromedriver-83
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();
    }
}