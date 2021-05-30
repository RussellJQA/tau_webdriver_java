package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class KeyPressesPage {

    private WebDriver driver;

    private final By inputField = By.id("target");
    private final By resulttext = By.id("result");

    public KeyPressesPage(WebDriver driver) { this.driver = driver; }

    public void enterText(String text) { driver.findElement(inputField).sendKeys(text); }

    public void enterPi() {
        /* The course video said to use this, and showed it working on a Mac. But it doesn't currently work in Chrome on Windows. */
        /* It enters "p" rather than "π".
        // enterText(Keys.chord(Keys.ALT, "p") + "=3.14");

        /* I tried instead using an Actions class, as at https://www.edureka.co/community/50029/how-handle-multiple-keyboard-keys-using-selenium-webdriver */
        /* But that didn't work either. So I tried typing ALT+P manually in the field in Chrome, and that didn't work either. */
        // driver.findElement(inputField).click();
        // Actions action = new Actions(driver);
        // action.keyDown(Keys.ALT).sendKeys("p").keyUp(Keys.ALT).sendKeys("=3.14").perform();

        /* Next, I tried using ALT + 0960 (on the numeric keypad), based on https://www.howtotype.net/symbol/Pi_symbol/ */
        /* But that didn't work either. Presumably, that's because of the caution given at that Web page: */
        /*      "Note: alt code greater than 255 are not universal and will only work in applications that support them such as Wordpad or Words" */
        /* I tried typing that manually in the field in Chrome, and it didn't work there either. But it did in WordPad. */
        // WebElement input = driver.findElement(inputField);
        // input.click();
        // Actions action = new Actions(driver);
        // action.keyDown(Keys.ALT).sendKeys(Keys.NUMPAD0).sendKeys(Keys.NUMPAD9).sendKeys(Keys.NUMPAD6).sendKeys(Keys.NUMPAD0).keyUp(Keys.ALT).sendKeys("=3.14").perform();

        /* Finally, I found something that works. *
        /* I based it on the Unicode examples at https://seleniumhome.blogspot.com/2013/07/sending-special-characters-and-key.html, */
        /* using the Unicode character encoding of "π" from https://en.wikipedia.org/wiki/Pi_(letter). */
        WebElement input = driver.findElement(inputField);
        input.sendKeys("\u03C0");
        input.sendKeys("=3.14");
    }

    public String getResponse() { return driver.findElement(resulttext).getText(); }

    /* I added this, to assert against in testPi(). [No assert was used in the class example.] */
    public String getEnteredText() { return driver.findElement(inputField).getAttribute("value"); }
}