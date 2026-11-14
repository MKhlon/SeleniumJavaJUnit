package automation.tests.elements;

import automation.steps.NavigateSteps;
import automation.tests.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ButtonsTest extends BaseTest {

   private NavigateSteps navigateSteps;

   @BeforeEach
   void initializeSteps() {
      navigateSteps = new NavigateSteps(driver());
      navigateSteps.openHomePage();
   }

   @Test
   public void doubleClickButtonTest() {
      //When
      navigateSteps
            .navigateToElementsPage()
            .navigateToButtonsComponent()
            .performDoubleClickButton()
      //Then
            .verifyDoubleClickButtonMessage(
              "You have done a double click");
   }
}
