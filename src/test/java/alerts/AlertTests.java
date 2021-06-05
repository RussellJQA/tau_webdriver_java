package alerts;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.AlertsPage;

import static org.testng.Assert.assertEquals;

public class AlertTests extends BaseTests {

    @Test
    public void testAcceptAlert() {
        AlertsPage alertsPage = homePage.clickJavaScripAlerts();
        alertsPage.triggerAlert();
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(), "You successfully clicked an alert", "Result text incorrect");
    }

    @Test
    public void testGetTextFromAlert() {
        AlertsPage alertsPage = homePage.clickJavaScripAlerts();
        alertsPage.triggerConfirm();
        String text = alertsPage.alert_GetText();
        alertsPage.alert_clickToDismiss();
        assertEquals(text, "I am a JS Confirm", "Alert text incorrect");
    }

    @Test
    public void testSetInputInAlert() {
        AlertsPage alertsPage = homePage.clickJavaScripAlerts();
        alertsPage.triggerPrompt();

        String text = "TAU rocks!";
        alertsPage.alert_SetInput(text);
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(), "You entered: " + text, "Result text incorrect");
    }
}