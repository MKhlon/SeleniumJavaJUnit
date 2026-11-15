package org.example.automation.pages.elements;

import lombok.Getter;
import org.example.automation.pages.BasePage;
import org.openqa.selenium.WebDriver;

@Getter
public class ElementsPage extends BasePage {
   private final TextBoxPage textBoxPage;
   private final CheckBoxPage checkBoxPage;
   private final ButtonsPage buttonsPage;
   private final WebTablesPage webTablesPage;
   private final UploadDownloadPage uploadDownloadComponent;

   public ElementsPage(WebDriver driver) {
       super(driver);
       this.textBoxPage = new TextBoxPage(driver);
       this.checkBoxPage = new CheckBoxPage(driver);
       this.buttonsPage = new ButtonsPage(driver);
       this.webTablesPage = new WebTablesPage(driver);
       this.uploadDownloadComponent = new UploadDownloadPage(driver);
   }
}
