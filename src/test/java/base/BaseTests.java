package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();  // close the browser and end the session [close() will only close the browser)]
    }
}