package utils;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class CookieManager {

    private final WebDriver driver;

    public CookieManager(WebDriver driver) {
        this.driver = driver;
    }

    public void deleteCookie(String cookieName) {
        driver.manage().deleteCookieNamed(cookieName);
    }

    public boolean isCookiePresent(String cookieName) {
        return !Objects.isNull(driver.manage().getCookieNamed(cookieName));
    }
}