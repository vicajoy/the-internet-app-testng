package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage extends BasePage {

    private By inputField = By.id("file-upload");
    private By uploadButton = By.id("file-submit");
    private By uploadedFiles = By.id("uploaded-files");

    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    public void clickUploadButton() {
        click(uploadButton);
    }

    /** Provides path of file to the form then clicks Upload button */
    public void uploadFile(String fileName) {
        String absolutePathOfFile = System.getProperty("user.dir") + "/src/main/resources/files/" + fileName;
        type(absolutePathOfFile, inputField);
        clickUploadButton();
    }

    public String getUploadedFiles() {
        return getText(uploadedFiles);
    }
}
