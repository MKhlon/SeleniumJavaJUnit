package org.example.automation.pages.elements;

import lombok.Data;
import org.example.automation.pages.BasePage;

@Data
public class ElementsPage extends BasePage {
   private final TextComponent textComponent;
   private final ButtonsComponent buttonsComponent;

   public ElementsPage() {
       this.textComponent = new TextComponent();
       this.buttonsComponent = new ButtonsComponent();
   }
}
