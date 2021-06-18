package utils;

import org.openqa.selenium.WebDriver;

public class WindowManager {

    private WebDriver driver;
    private WebDriver.Navigation navigate;

    public WindowManager(WebDriver driver) {
        this.driver = driver;
        navigate = driver.navigate();
    }

    public void goBack() { navigate.back(); }
    public void goForward() { navigate.forward(); }
    public void goTo(String url) { navigate.to(url); }  // driver.get() waits for the page to load, but driver.navigate.to() does not
    public void refreshPage() { navigate.refresh(); }

    public String getCurrentWindow() {
        return driver.getWindowHandle();
    }

    public void switchToTab(String tabTitle) {
        var windows = driver.getWindowHandles();

        System.out.println("Number of tabs: " + windows.size());

        System.out.println("Window handles:");

        // Loop through all of the windows handles, and print them
        /* windows.forEach(window -> System.out.println(window)); */
        windows.forEach(System.out::println);  // Lambda can be replaced with method reference

        for(String window: windows) {
            System.out.println("Switching to window: " + window);
            driver.switchTo().window(window);

            System.out.println("Current window title: " + driver.getTitle());

            if(tabTitle.equals(driver.getTitle())) {
                break;
            }
        }
    }

    public void switchToOtherTab(String originalTab) {
        var windows = driver.getWindowHandles();
        for(String window: windows) {
            driver.switchTo().window(window);
            if(!driver.getWindowHandle().equals(originalTab)) {
                break;
            }
        }
    }
}