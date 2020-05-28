import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class FileUploadTests extends BaseTests {

    @Test
    public void testImageUpload() {

        var fileUploadPage = homePage.clickFileUpload();
        String fileName = "java.jpg";
        fileUploadPage.uploadFile(fileName);
        String fileNames = fileUploadPage.getUploadedFiles();
        assertTrue(fileNames.contains(fileName),
                "File (" + fileName + ") has not been uploaded.");
    }
}
