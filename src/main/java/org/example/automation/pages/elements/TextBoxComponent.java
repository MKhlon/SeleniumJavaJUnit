package org.example.automation.pages.elements;

import org.example.automation.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class TextBoxComponent extends BasePage {
    private final By fullNameText = By.id("userName");
    private final By emailText = By.id("userEmail");
    private final By outputContainer = By.id("output");
    private final By outputLines = By.cssSelector("#output p");

    public TextBoxComponent(WebDriver driver) {
        super(driver);
    }

    public void setFullName(String fullName) {
        type(fullNameText, fullName);
    }

    public void setEmail(String email) {
        type(emailText, email);
    }

    public List<String> getOutputLines() {
        waitUtils.waitForElementToBeVisible(outputContainer);

        return driver.findElements(outputLines)
                .stream()
                .map(WebElement::getText)
                .toList();
    }
}
