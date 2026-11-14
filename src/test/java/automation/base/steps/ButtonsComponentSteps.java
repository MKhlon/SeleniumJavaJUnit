package automation.base.steps;

import org.example.automation.pages.BasePage;
import org.example.automation.pages.elements.ElementsPage;
import org.junit.jupiter.api.Assertions;

public class ButtonsComponentSteps extends BaseSteps {

    private final ElementsPage elementsPage;

    public ButtonsComponentSteps(){
        this.elementsPage = new ElementsPage();
    }

    public void performDoubleClickButton() {
        elementsPage.getButtonsComponent().clickDoubleClickButton();
    }

    public void verifyDoubleClickButtonMessage(String expectedMessage) {
        Assertions.assertEquals(elementsPage.getButtonsComponent().getDoubleClickButtonMessage(),
                expectedMessage, "Message is not as expected");
    }
}
