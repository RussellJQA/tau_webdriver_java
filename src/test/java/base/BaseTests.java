package base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTests {

    protected HomePage homePage;
    private EventFiringWebDriver driver;

    @BeforeClass
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        driver = new EventFiringWebDriver(new ChromeDriver());

        driver.register(new EventReporter());

        // Caution: Be careful when using implicit waits because you're setting this at the project level,
        // meaning it will wait up until this amount of time for all interactions,
        // and this could slow down your project if you're not careful.
        /* driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); */

        // TODO: Do I want to include this or not?
        // Wait up to 30 seconds (the default value) for page loads to be complete.
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        goHome();

        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void goHome() {
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;

            // NOTE: This saves the screenshot into a temporary file that is deleted when the JVM exits.
            //      See https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/OutputType.html
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            System.out.println("Screenshot temporarily saved to: " + screenshot.getAbsolutePath());

            try {
                // Files.move(screenshot, new File("resources/screenshots/test2.png"));
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    } // close the browser and end the session [close() will only close the browser)]

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }
}