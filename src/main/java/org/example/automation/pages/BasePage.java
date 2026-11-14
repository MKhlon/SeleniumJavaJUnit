package org.example.automation.pages;


import org.example.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePage {
    protected final WebDriver driver;
    protected final WaitUtils waitUtils;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    private final By submitButton = By.id("submit");

    protected void click(By locator) {
        waitUtils.waitForClick(locator);
    }

    protected void clickWithInterception(By locator) {
        waitUtils.waitForClickWithInterception(locator);
    }

    protected void doubleClick(By locator) {
        new Actions(driver)
                .doubleClick(
                        waitUtils.waitForElementToBeClickable(locator))
                .perform();
    }

    protected String getText(By locator) {
        return waitUtils.waitForElementToBeVisible(locator).getText();
    }

    protected void type(By locator, String text) {
        WebElement element =
                waitUtils.waitForElementToBeVisible(locator);

        element.clear();
        element.sendKeys(text);
    }

    public void clickSubmit() {
        clickWithInterception(submitButton);
    }
}
