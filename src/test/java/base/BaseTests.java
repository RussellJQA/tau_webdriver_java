package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.WindowManager;

import java.util.concurrent.TimeUnit;

public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        driver = new ChromeDriver();

        // Caution: Be careful when using implicit waits because you're setting this at the project level,
        // meaning it will wait up until this amount of time for all interactions,
        // and this could slow down your project if you're not careful.
        /* driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); */

        // Wait up to 30 seconds (the default value) for page loads to be complete.
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        goHome();

        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void goHome() {
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterClass
    public void tearDown() { driver.quit(); } // close the browser and end the session [close() will only close the browser)]

    public WindowManager getWindowManager() { return new WindowManager(driver); }
}