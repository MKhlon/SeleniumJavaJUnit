package automation.base.steps;

import org.example.automation.pages.elements.ElementsPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class ButtonsComponentSteps extends BaseSteps {

    private final ElementsPage elementsPage;

    public ButtonsComponentSteps(WebDriver driver) {
        super(driver);
        this.elementsPage = new ElementsPage(driver);
    }

    public void performDoubleClickButton() {
        elementsPage.getButtonsComponent().clickDoubleClickButton();
    }

    public void verifyDoubleClickButtonMessage(String expectedMessage) {
        Assertions.assertEquals(
                expectedMessage,
                elementsPage.getButtonsComponent().getDoubleClickButtonMessage(),
                "Message is not as expected");
    }
}
