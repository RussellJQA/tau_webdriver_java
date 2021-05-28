package exercises.chapter4.passwords;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/***
 * NOTE: This exercise cannot currently be fully tested, because of an existing bug on
 * the [Forgot Password](https://the-internet.herokuapp.com/forgot_password) page.
 *
 * See https://github.com/saucelabs/the-internet/issues/68
 * (submitted by the instructor for this course [Angie Jones]).
 */

/* NOTE: This exercise cannot currently be tested, because of an existing bug on */

public class ForgotPasswordTests extends BaseTests {

    @Test
    public void testForgotPassword() {

        var forgotPasswordPage = homePage.clickForgotPassword();

        // Enter Email and click "Retrieve password" button
        forgotPasswordPage.setEmail("tau@example.com");
        var emailSentPage = forgotPasswordPage.clickRetrievePasswordButton();

        // Assert that results are as expected
        assertEquals(emailSentPage.getMessage(), "Your email's been sent:", "Message is incorrect");
    }
}