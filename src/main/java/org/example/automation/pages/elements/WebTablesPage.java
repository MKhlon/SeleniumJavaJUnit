package org.example.automation.pages.elements;

import lombok.Getter;
import org.example.automation.components.RegistrationFormComponent;
import org.example.automation.components.WebTable;
import org.example.automation.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Getter
public class WebTablesPage extends BasePage {
    private final RegistrationFormComponent registrationFormComponent;
    private final By editButton = By.id("edit-record-1");
    private final WebTable webTable;

    public WebTablesPage(WebDriver driver) {
        super(driver);
        this.registrationFormComponent = new RegistrationFormComponent(driver);
        this.webTable = new WebTable(driver);
    }

    public RegistrationFormComponent clickEdit() {
        click(editButton);
        return new RegistrationFormComponent(driver);
    }

}
