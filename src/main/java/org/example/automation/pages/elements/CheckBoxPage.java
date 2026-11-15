package org.example.automation.pages.elements;

import org.example.automation.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxPage extends BasePage {

    private final By homeTreeExpander = By.xpath(
            "//span[@title='Home']/preceding-sibling::span[contains(@class,'rc-tree-switcher')]");
    private final By desktopTreeExpander = By.xpath(
            "//span[@title='Desktop']/preceding-sibling::span[contains(@class,'rc-tree-switcher')]");

    private final By notesCheckbox = By.xpath(
            "//span[@title='Notes']/preceding-sibling::span[@role='checkbox']");
    private final By resultOutput = By.id("result");
    private final By resultSpans = By.cssSelector("#result > span");

    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }

    public void clickExpandHomeTree() {
        click(homeTreeExpander);
    }

    public void clickExpandDesktopTree() {
        click(desktopTreeExpander);
    }

    public void clickNotesCheckbox() {
        click(notesCheckbox);
    }

    public List<String> getResultMessages() {
        waitUtils.waitForElementToBeVisible(resultOutput);

        return driver.findElements(resultSpans)
                .stream()
                .map(WebElement::getText)
                .toList();
    }
}
