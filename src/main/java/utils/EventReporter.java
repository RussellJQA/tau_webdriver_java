package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

// TODO: Acc. to
// https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/events/WebDriverEventListener.html
// WebDriverEventListener has been deprecated:
//      Use EventFiringDecorator and WebDriverListener instead
public class EventReporter implements WebDriverEventListener {

    @Override
    public void beforeAlertAccept(WebDriver webDriver) {
    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {
    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {
    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {
    }

    @Override
    public void beforeNavigateTo(String s, WebDriver webDriver) {
        System.out.println("Navigating to: " + s);
    }

    @Override
    public void afterNavigateTo(String s, WebDriver webDriver) {
    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {
    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {
    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {
    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {
    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {
    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {
    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        System.out.println("Clicking on element: " + webElement.getText());
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {
        System.out.println("Executing script: " + s);
    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {
    }

    @Override
    public void beforeSwitchToWindow(String s, WebDriver webDriver) {
        System.out.println("Switching to window: " + s);
    }

    @Override
    public void afterSwitchToWindow(String s, WebDriver webDriver) {
    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {
    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {
    }

    @Override
    public void beforeGetText(WebElement webElement, WebDriver webDriver) {
    }

    @Override
    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {
        System.out.println("Got text of: " + s);
    }
}