package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.testng.Assert.*;

public class LoginTests extends BaseTests {

   @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage = homePage.clickFormAuthenticationLink();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();

       /* assertEquals() fails due to spacing issues and a closing "x" in the secure area */
       // assertEquals(secureAreaPage.getAlertText(),
       //       "You logged into a secure area!",
       //       "Alert text is incorrect");
       assertTrue(secureAreaPage.getAlertText()
               .contains("You logged into a secure area!"),
               "Alert text is incorrect");
    }
}