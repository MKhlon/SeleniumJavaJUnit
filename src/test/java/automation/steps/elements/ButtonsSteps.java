package automation.steps.elements;

import automation.steps.BaseSteps;
import org.example.automation.pages.elements.ElementsPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class ButtonsSteps extends BaseSteps {

    private final ElementsPage elementsPage;

    public ButtonsSteps(WebDriver driver) {
        super(driver);
        this.elementsPage = new ElementsPage(driver);
    }

    public ButtonsSteps performDoubleClickButton() {
        elementsPage.getButtonsComponent().clickDoubleClickButton();
        return this;
    }

    public void verifyDoubleClickButtonMessage(String expectedMessage) {
        Assertions.assertEquals(
                expectedMessage,
                elementsPage.getButtonsComponent().getDoubleClickButtonMessage(),
                "Message is not as expected");
    }
}
