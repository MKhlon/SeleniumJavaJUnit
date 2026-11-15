package org.example.automation.pages.elements;

import lombok.Getter;
import org.example.automation.pages.BasePage;
import org.openqa.selenium.WebDriver;

@Getter
public class ElementsPage extends BasePage {
   private final TextBoxComponent textBoxComponent;
   private final CheckBoxComponent checkBoxComponent;
   private final ButtonsComponent buttonsComponent;
   private final WebTablesComponent webTablesComponent;

   public ElementsPage(WebDriver driver) {
       super(driver);
       this.textBoxComponent = new TextBoxComponent(driver);
       this.checkBoxComponent = new CheckBoxComponent(driver);
       this.buttonsComponent = new ButtonsComponent(driver);
       this.webTablesComponent = new WebTablesComponent(driver);
   }
}
