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
        elementsPage.getCheckBoxPage().clickExpandHomeTree();
        return this;
    }

    public CheckBoxSteps clickExpandDesktopTree() {
        elementsPage.getCheckBoxPage().clickExpandDesktopTree();
        return this;
    }

    public CheckBoxSteps clickNotesCheckbox() {
        elementsPage.getCheckBoxPage().clickNotesCheckbox();
        return this;
    }

    public void verifyResultMessages(List<String> expectedMessages) {
        List<String> actualMessages = elementsPage.getCheckBoxPage().getResultMessages();
        Assertions.assertEquals(
                expectedMessages,
                actualMessages,
                "Result messages are not as expected");
    }
}
