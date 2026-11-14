package automation.tests.elements;

import automation.steps.NavigateSteps;
import automation.steps.elements.TextBoxSteps;
import automation.tests.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TextBoxTest extends BaseTest {
    private TextBoxSteps textBoxSteps;
    private NavigateSteps navigateSteps;

    @BeforeEach
    void initializeSteps() {
        this.textBoxSteps = new TextBoxSteps(driver());
        this.navigateSteps = new NavigateSteps(driver());
        navigateSteps.openHomePage();
    }

    @Test
    void textSubmissionTest() {
       //Given
       final var fullName = "Full Name Default";
       final var email = "email@example.com";

       //When
       navigateSteps.navigateToElementsPage()
               .navigateToTextBoxComponent()
               .enterFullName(fullName)
               .enterEmail(email)
               .clickSubmit();

       //Then
       textBoxSteps.verifySubmittedDetails(fullName, email);
    }
}
