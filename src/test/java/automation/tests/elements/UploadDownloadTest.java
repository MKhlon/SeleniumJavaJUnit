package automation.tests.elements;

import automation.steps.NavigateSteps;
import automation.tests.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UploadDownloadTest extends BaseTest {

    private NavigateSteps navigateSteps;

    @BeforeEach
    void initializeSteps() {
        this.navigateSteps = new NavigateSteps(driver());
        navigateSteps.openHomePage();
    }

    @Test
    public void uploadTest() {
        //Given
        final var fileName = "sample.txt";

        //When
        navigateSteps
                .navigateToElementsPage()
                .navigateToUploadDownloadPage()
                .uploadFile(fileName)

                //Then
                .verifyUploadedFilePath(fileName);
    }
}
