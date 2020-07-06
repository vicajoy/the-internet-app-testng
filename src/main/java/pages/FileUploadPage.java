package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage extends Page {

    private By inputField = By.id("file-upload");
    private By uploadButton = By.id("file-submit");
    private By uploadedFiles = By.id("uploaded-files");

    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    /** Clicks Upload button */
    public void clickUploadButton() {
        click(uploadButton);
    }

    /**
     * Provides path of file to the form then clicks Upload button
     * @param fileName     String - file name that is being passed to the absolute path
     */
    public void uploadFile(String fileName) {
        String absolutePathOfFile = System.getProperty("user.dir") + "/src/main/resources/files/" + fileName;
        type(absolutePathOfFile, inputField);
        clickUploadButton();
    }

    /**
     * Gets the text of uploaded files
     * @return      String - text of uploaded files
     */
    public String getUploadedFiles() {
        return getText(uploadedFiles);
    }
}
