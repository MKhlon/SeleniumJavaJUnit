package automation.steps.elements;

import automation.steps.BaseSteps;
import org.example.automation.pages.elements.ElementsPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class CheckBoxSteps extends BaseSteps {
    private final ElementsPage elementsPage;

    public CheckBoxSteps(WebDriver driver) {
        super(driver);
        this.elementsPage = new ElementsPage(driver);
    }

    public CheckBoxSteps clickExpandHomeTree() {
        elementsPage.getCheckBoxComponent().clickExpandHomeTree();
        return this;
    }

    public CheckBoxSteps clickExpandDesktopTree() {
        elementsPage.getCheckBoxComponent().clickExpandDesktopTree();
        return this;
    }

    public CheckBoxSteps clickNotesCheckbox() {
        elementsPage.getCheckBoxComponent().clickNotesCheckbox();
        return this;
    }

    public void verifyResultMessages(List<String> expectedMessages) {
        List<String> actualMessages = elementsPage.getCheckBoxComponent().getResultMessages();
        Assertions.assertEquals(
                expectedMessages,
                actualMessages,
                "Result messages are not as expected");
    }
}
