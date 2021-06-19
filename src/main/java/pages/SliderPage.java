package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SliderPage {

    private static final By sliderValue = By.id("range");
    private static final By sliderControl = By.cssSelector(".sliderContainer input");
    private final WebDriver driver;

    public SliderPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getSliderValue() {
        return driver.findElement(sliderValue).getText();
    }

    public void setSliderValue(int value) {
        WebElement sliderElement = driver.findElement(sliderControl);
        sliderElement.click();
        while (!getSliderValue().equals(String.valueOf(value))) {
            sliderElement.sendKeys(Keys.ARROW_RIGHT);
        }
    }
}