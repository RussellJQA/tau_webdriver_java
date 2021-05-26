package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;

    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        // From https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/WebDriver.html
        // Known WebDriver Implementing classes include ChromeDriver, ChromiumDriver, EdgeDriver, EventFiringWebDriver,
        // FirefoxDriver, InternetExplorerDriver, OperaDriver, RemoteWebDriver, and SafariDriver
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        homePage = new HomePage(driver);

        driver.quit();  // close the browser and end the session [close() will only close the browser)
    }

    public static void main(String[] args) {
        BaseTests test = new BaseTests();
        test.setUp();
    }
}