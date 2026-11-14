package automation.tests;

import automation.base.steps.ButtonsComponentSteps;
import automation.base.steps.NavigateSteps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ButtonsComponentTest extends BaseTest {

   private ButtonsComponentSteps buttonsComponentSteps;
   private NavigateSteps navigateSteps;

   @BeforeEach
   void initializeSteps() {
      buttonsComponentSteps = new ButtonsComponentSteps(driver());
      navigateSteps = new NavigateSteps(driver());
      navigateSteps.openHomePage();
   }

   @Test
   public void doubleClickButtonTest() {
      //When
      navigateSteps.navigateToElementsPage();
      navigateSteps.navigateToButtonsComponent();
      buttonsComponentSteps.performDoubleClickButton();
      //Then
      buttonsComponentSteps.verifyDoubleClickButtonMessage(
              "You have done a double click");
   }
}
