package automation.tests.elements;

import automation.steps.NavigateSteps;
import automation.tests.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class CheckBoxTest extends BaseTest {

    private NavigateSteps navigateSteps;

    @BeforeEach
    void initializeSteps() {
        this.navigateSteps = new NavigateSteps(driver());
        navigateSteps.openHomePage();
    }

    @Test
    public void checkBoxTest() {
        //When
        navigateSteps.navigateToElementsPage()
                .navigateToCheckBoxPage()
                .clickExpandHomeTree()
                .clickExpandDesktopTree()
                .clickNotesCheckbox()

        //Then
                .verifyResultMessages(
                        List.of("You have selected :", "notes"));
    }
}
