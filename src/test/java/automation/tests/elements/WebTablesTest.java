package automation.tests.elements;

import automation.steps.NavigateSteps;
import automation.steps.elements.WebTablesSteps;
import automation.tests.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WebTablesTest extends BaseTest {

    private WebTablesSteps webTablesSteps;
    private NavigateSteps navigateSteps;

    @BeforeEach
    void initializeSteps() {
        this.webTablesSteps = new WebTablesSteps(driver());
        this.navigateSteps = new NavigateSteps(driver());
        navigateSteps.openHomePage();
    }

    @Test
    public void editRegistrationFormTest() {
        //Given
        final var firstName = "John";
        final var lastName = "Doe";
        final var rowIndex = 1;

        //When
        navigateSteps
                .navigateToElementsPage()
                .navigateToWebTablesPage()
                .editRecord()
                .setFirstName(firstName)
                .setLastName(lastName)
                .clickSubmit();

        //Then
        webTablesSteps.verifyRecordUpdated(firstName, lastName, rowIndex);
    }
}
