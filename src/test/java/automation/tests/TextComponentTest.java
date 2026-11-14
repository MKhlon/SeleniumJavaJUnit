package automation.tests;

import automation.base.steps.NavigateSteps;
import automation.base.steps.TextComponentSteps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TextComponentTest extends BaseTest {
    private TextComponentSteps textComponentSteps;
    private NavigateSteps navigateSteps;

    @BeforeEach
    void initializeSteps() {
        this.textComponentSteps = new TextComponentSteps();
        this.navigateSteps = new NavigateSteps();
        navigateSteps.openHomePage();
    }

    @Test
    void textSubmissionTest() {
       //Given
       final var fullName = "Full Name Default";
       final var email = "email@example.com";

       //When
       navigateSteps.navigateToElementsPage();
       navigateSteps.navigateToTextComponent();
       textComponentSteps.enterFullName(fullName);
       textComponentSteps.enterEmail(email);
       navigateSteps.clickSubmit();

       //Then
      textComponentSteps.verifyOutputText(true, true, false, false);
    }
}
