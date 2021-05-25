package base;

import org.openqa.selenium.By;
// import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BaseTests {

    private WebDriver driver;

    public void setUp() {

        /* Chapter 1 example code */

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        // From https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/WebDriver.html
        // Known WebDriver Implementing classes include ChromeDriver, ChromiumDriver, EdgeDriver, EventFiringWebDriver,
        // FirefoxDriver, InternetExplorerDriver, OperaDriver, RemoteWebDriver, and SafariDriver
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        // driver.manage().window().maximize();     // Maximize the browser window
        // driver.manage().window().fullscreen();   // Set browser window to full screen
        // driver.manage().window().setSize(new Dimension(375, 812));  // Set browser window to iPhone X size

        /* Chapter 2 example code */

        // System.out.println(driver.getTitle());

        /* Chapter 3 example code */

//        List<WebElement> links = driver.findElements(By.tagName("a"));
//        System.out.println(links.size());
//
//        WebElement inputsLink = driver.findElement(By.linkText("Inputs"));
//        inputsLink.click();

        /* Chapter 3 exercise */

        driver.findElement(By.linkText("Shifting Content")).click();
        driver.findElement(By.linkText("Example 1: Menu Element")).click();
        List<WebElement> menuElements = driver.findElements(By.xpath("//li/a"));
        System.out.printf("%nNumber of 'Example 1' menu elements: %s%n", menuElements.size());

        driver.quit();  // close the browser and end the session [close() will only close the browser)
    }

    public static void main(String[] args) {
        BaseTests test = new BaseTests();
        test.setUp();
    }
}