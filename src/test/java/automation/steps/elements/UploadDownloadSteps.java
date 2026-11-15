package automation.steps.elements;

import automation.steps.BaseSteps;
import org.example.automation.pages.elements.ElementsPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadDownloadSteps extends BaseSteps {
    private final ElementsPage elementsPage;

    public UploadDownloadSteps(WebDriver driver) {
        super(driver);
        this.elementsPage = new ElementsPage(driver);
    }

    public UploadDownloadSteps uploadFile(String fileName) {
        Path filePath = Paths.get(
                "src", "test", "resources", "testData", fileName).toAbsolutePath();
        if (!Files.isRegularFile(filePath)) {
            throw new IllegalArgumentException(
                    "Upload file not found: " + filePath);
        }
        elementsPage.getUploadDownloadComponent().uploadFile(filePath.toString());
        return this;
    }

    public void verifyUploadedFilePath(String fileName) {
        String actualFilePath = elementsPage.getUploadDownloadComponent().getUploadedFilePath();

        String expectedFilePath = "C:\\fakepath\\" + fileName;
        Assertions.assertEquals(
                expectedFilePath,
                actualFilePath,
                "Uploaded file path is not as expected");
    }
}
