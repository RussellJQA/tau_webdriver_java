package alerts;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.FileUploadPage;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {

    @Test
    public void testFileUpload() {
        FileUploadPage fileUploadPage = homePage.clickFileUpload();
        fileUploadPage.uploadFile("C:\\Users\\rljohnson\\IdeaProjects\\tau_webdriver_java\\resources\\chromedriver.exe");
        assertEquals(fileUploadPage.getUploadedFiles(), "chromedriver.exe", "File upload error");
    }
}