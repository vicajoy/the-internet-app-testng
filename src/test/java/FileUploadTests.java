import base.DataProviders;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class FileUploadTests extends DataProviders {

    @Feature(value = "File Upload")
    @Test(dataProvider = "files")
    public void testFileUpload(String fileName) {

        var fileUploadPage = homePage.clickFileUpload();
        fileUploadPage.uploadFile(fileName);
        String fileNames = fileUploadPage.getUploadedFiles();
        assertTrue(fileNames.contains(fileName),
                "File (" + fileName + ") has not been uploaded.");
    }
}
