package org.example.automation.components;

import lombok.Getter;
import org.example.automation.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Getter
public class RegistrationFormComponent extends BasePage {
    private final By modal = By.cssSelector("[role='dialog']");
    private final By firstNameInput = By.id("firstName");
    private final By lastNameInput = By.id("lastName");

    public RegistrationFormComponent(WebDriver driver) {
        super(driver);
    }

    public RegistrationFormComponent setFirstName(String firstName) {
        type(firstNameInput, firstName);
        return this;
    }

    public RegistrationFormComponent setLastName(String lastName) {
        type(lastNameInput, lastName);
        return this;
    }
}
