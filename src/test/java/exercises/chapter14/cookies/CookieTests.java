package exercises.chapter14.cookies;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.CookieManager;

import static org.testng.Assert.assertFalse;

public class CookieTests extends BaseTests {

    @Test
    public void testDeleteCookie() {
        String cookieToDelete = "optimizelyBuckets";
        CookieManager cookieManager = getCookieManager();
        if (cookieManager.isCookiePresent(cookieToDelete)) {
            cookieManager.deleteCookie(cookieToDelete);
            assertFalse(cookieManager.isCookiePresent(cookieToDelete),
                    ("Cookie '" + cookieToDelete + "' was unsuccessfully deleted"));
        } else {
            Assert.fail("Cookie '" + cookieToDelete + "' does not exist");
        }
    }
}