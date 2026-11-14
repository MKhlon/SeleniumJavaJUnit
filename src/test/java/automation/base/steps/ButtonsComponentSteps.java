package automation.base.steps;

import org.example.automation.pages.ButtonsPage;
import org.junit.jupiter.api.Assertions;

public class ButtonsPageSteps extends BasePage {

    private final ButtonsPage buttonsPage;

    public ButtonsPageSteps(){
        this.buttonsPage = new ButtonsPage();
    }

    public void performDoubleClickButton() {
        buttonsPage.clickDoubleClickButton();
    }

    public void verifyDoubleClickButtonMessage(String expectedMessage) {
        Assertions.assertEquals(buttonsPage.getDoubleClickButtonMessage(),
                expectedMessage, "Message is not as expected");
    }
}
