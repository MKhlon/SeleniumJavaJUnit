package org.example.automation.pages.elements;


import lombok.Data;
import org.example.automation.pages.BasePage;
import org.openqa.selenium.By;
@Data
public class ButtonsComponent extends BasePage {
   //Locators
   private final By clickDynamicButton = By.id("2Chhf");
   private final By doubleClickButton = By.id("doubleClickBtn");
   private final By rightClickButton = By.id("rightClickBtn");

   //Messages
   private final By clickDynamicButtonMessage = By.id("dynamicClickMessage");
   private final By doubleClickButtonMessage = By.id("doubleClickMessage");
   private final By rightClickButtonMessage = By.id("rightClickMessage");

   public void clickDynamicButton() {
      click(clickDynamicButton);
   }

   public void clickDoubleClickButton() {
      doubleClick(doubleClickButton);
   }

   public String getDynamicButtonMessage() {
      return getText(clickDynamicButtonMessage);
   }

   public String getDoubleClickButtonMessage() {
      return getText(doubleClickButtonMessage);
   }

   public String getRightClickButtonMessage() {
      return getText(rightClickButtonMessage);
   }
}
