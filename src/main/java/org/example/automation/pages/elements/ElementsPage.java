package org.example.automation.pages.elements;

import org.example.automation.pages.BasePage;
import org.openqa.selenium.WebDriver;

public class ElementsPage extends BasePage {
   private final TextBoxComponent textBoxComponent;
   private final CheckBoxComponent checkBoxComponent;
   private final ButtonsComponent buttonsComponent;

   public ElementsPage(WebDriver driver) {
       super(driver);
       this.textBoxComponent = new TextBoxComponent(driver);
       this.checkBoxComponent = new CheckBoxComponent(driver);
       this.buttonsComponent = new ButtonsComponent(driver);
   }

   public TextBoxComponent getTextBoxComponent() {
       return textBoxComponent;
   }

   public CheckBoxComponent getCheckBoxComponent() {
       return checkBoxComponent;
   }

   public ButtonsComponent getButtonsComponent() {
       return buttonsComponent;
   }
}
