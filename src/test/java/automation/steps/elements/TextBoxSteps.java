package automation.steps.elements;

import automation.steps.BaseSteps;
import org.example.automation.pages.elements.ElementsPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class TextBoxSteps extends BaseSteps {

    private final ElementsPage elementsPage;

    public TextBoxSteps(WebDriver driver) {
        super(driver);
        this.elementsPage = new ElementsPage(driver);
    }

    public TextBoxSteps enterFullName(String fullName) {
        elementsPage.getTextBoxComponent().setFullName(fullName);
        return this;
    }

    public TextBoxSteps enterEmail(String email) {
        elementsPage.getTextBoxComponent().setEmail(email);
        return this;
    }

    public void verifySubmittedDetails(String fullName, String email) {
        Assertions.assertEquals(
                List.of("Name:" + fullName, "Email:" + email),
                elementsPage.getTextBoxComponent().getOutputLines(),
                "Submitted details are not as expected");
    }
}
