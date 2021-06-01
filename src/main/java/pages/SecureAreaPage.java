package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {

    private WebDriver driver;
    public final By statusAlert = By.id("flash");  // XPath="//div[@id='flash']", CSS="#flash"

    public SecureAreaPage(WebDriver driver) { this.driver = driver; }

    public String getAlertText() { return driver.findElement(statusAlert).getText(); }
}