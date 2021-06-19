package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {
    private static final By triggerAlertButton = By.xpath("//button[text()='Click for JS Alert']");
    private static final By triggerConfirmButton = By.xpath("//button[text()='Click for JS Confirm']");
    private static final By triggerPromptButton = By.xpath("//button[text()='Click for JS Prompt']");
    private static final By results = By.id("result");
    private final WebDriver driver;

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void triggerAlert() {
        driver.findElement(triggerAlertButton).click();
    }

    public void triggerConfirm() {
        driver.findElement(triggerConfirmButton).click();
    }

    public void triggerPrompt() {
        driver.findElement(triggerPromptButton).click();
    }

    public void alert_clickToAccept() {
        driver.switchTo().alert().accept();
    }

    public void alert_clickToDismiss() {
        driver.switchTo().alert().dismiss();
    }

    public String alert_GetText() {
        return driver.switchTo().alert().getText();
    }

    public void alert_SetInput(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    public String getResult() {
        return driver.findElement(results).getText();
    }
}