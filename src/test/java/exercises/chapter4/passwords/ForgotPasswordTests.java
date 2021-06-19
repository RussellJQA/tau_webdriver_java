package exercises.chapter4.passwords;

import base.BaseTests;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;
import pages.EmailSentPage;
import pages.ForgotPasswordPage;

import static org.testng.Assert.assertEquals;

/**
 * NOTE: The 'try' block below seeks to implement the original exercise.
 * But it's currently blocked by a Known Issue [See comments below.] on
 * the [Forgot Password](https://the-internet.herokuapp.com/forgot_password) page.
 * <p>
 * In the course Slack channel, the course instructor [Angie Jones] suggested an alternative:
 * "For the purpose of the lesson, you can just verify something else on that page -- like the error message lol"
 * So, I've implemented that in the 'catch' block.
 */

public class ForgotPasswordTests extends BaseTests {

    @Test
    public void testForgotPassword() {

        ForgotPasswordPage forgotPasswordPage = homePage.clickForgotPassword();

        // Enter Email address
        forgotPasswordPage.setEmail("tau@example.com");

        try {
            // Click the "Retrieve password" button
            EmailSentPage emailSentPage = forgotPasswordPage.clickRetrievePasswordButton();

            // Assert that results are as expected
            assertEquals(emailSentPage.getMessage(), "Your email's been sent:", "Message is incorrect");
        } catch (NoSuchElementException e) {
            System.out.println("\nExpected 'content' not found, presumably as a result of a Known Issue on the Web page." +
                    "\nSee [Retrieve Password button gives Internal Server Error · Issue #68]" +
                    "(https://github.com/saucelabs/the-internet/issues/68)\n");
            e.printStackTrace();

            System.out.println("\nSubstituting instructor-suggested alternative exercise.\n");
            assertEquals(forgotPasswordPage.getAlternateText(), "Internal Server Error", "Alternative exercise failed!");
        }
    }
}