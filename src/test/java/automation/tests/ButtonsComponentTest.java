package automation.tests;

import automation.base.steps.ButtonsPageSteps;
import automation.base.steps.NavigateSteps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ButtonsTest extends BaseTest {

   private ButtonsPageSteps buttonsPageSteps;
   private NavigateSteps navigateSteps;

   @BeforeEach
   void initializeSteps() {
      buttonsPageSteps = new ButtonsPageSteps();
      navigateSteps = new NavigateSteps();
      navigateSteps.openHomePage();
   }

   @Test
   public void doubleClickButtonTest() {
      //When
      navigateSteps.navigateToElementsPage();
      navigateSteps.navigateToButtonsPage();
      buttonsPageSteps.performDoubleClickButton();
      //Then
      buttonsPageSteps.verifyDoubleClickButtonMessage("You have done a double click");
   }
}
