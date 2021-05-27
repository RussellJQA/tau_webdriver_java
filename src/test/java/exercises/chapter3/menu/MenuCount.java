package exercises.chapter3.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class MenuCount {

    private WebDriver driver;

    public void printMenuCount() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Shifting Content")).click();
        driver.findElement(By.linkText("Example 1: Menu Element")).click();

        List<WebElement> menuElements = driver.findElements(By.xpath("//li/a"));
        System.out.printf("%nNumber of 'Example 1' menu elements: %s%n", menuElements.size());

        driver.quit();  // close the browser and end the session [close() will only close the browser)
    }

    public static void main(String[] args) {
        MenuCount menuCount = new MenuCount();
        menuCount.printMenuCount();
    }
}