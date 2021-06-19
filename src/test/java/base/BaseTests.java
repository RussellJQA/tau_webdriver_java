package base;

import com.google.common.io.Files;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.CookieManager;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTests {

    protected HomePage homePage;
    private EventFiringWebDriver driver;

    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();

        // June 19, 2021 UPDATE: The following does not work as expected, because "disable-infobars" has been deprecated
        //      For an alternative which does work, see the comments before the setExperimentalOption() call below.
        // Remove the "Chrome is being controlled by automated test software." 'infobar' (banner)
        /* options.addArguments("disable-infobars"); */

        /*
          Acc. to:
          "Previously, passing the "disable-infobars” ChromeOption to the WebDriver prevented Chrome from displaying
          this notification. Recently, the "disable-infobars" option has been deprecated and no longer removes the
          notification. The current workaround for this is to pass in an option called "excludeSwitches" and then
          exclude the "enable_automation" switch.

          CAUTION: Please review what the "enable_automation" switch does via the documentation and ensure your test
          suite does not rely on any features listed there before disabling it."
         */
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        // This was something the instructor wanted us to try as part of the course, but then to comment out for now.
        /* options.setHeadless(true); */

        return options;
    }

    private void setCookie() {
        Cookie cookie = new Cookie.Builder("tau", "123")
                .domain("the-internet.herokuapp.com")
                .build();  // By default, this seems to add a Secure, Medium-Priority Session cookie
        driver.manage().addCookie(cookie);
    }

    @BeforeClass
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());

        // Caution: Be careful when using implicit waits because you're setting this at the project level,
        // meaning it will wait up until this amount of time for all interactions,
        // and this could slow down your project if you're not careful.
        /* driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); */

        // TODO: Do I want to include this or not?
        // Wait up to 30 seconds (the default value) for page loads to be complete.
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        goHome();
        setCookie();
    }

    @BeforeMethod
    public void goHome() {
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            TakesScreenshot camera = driver;

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

    public CookieManager getCookieManager() {
        return new CookieManager(driver);
    }
}