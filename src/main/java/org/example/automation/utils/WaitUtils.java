package org.example.automation.utils;

import org.example.automation.config.ConfigReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private final WebDriverWait wait;

    public WaitUtils(WebDriver driver) {
        int timeout = Integer.parseInt(
                ConfigReader.get("explicit.wait.seconds")
        );

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(timeout)
        );
    }

    public WebElement waitForElementToBeVisible(By locator) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }

    public WebElement waitForElementToBeClickable(By locator) {
        return wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        );
    }

    public void waitForClick(By locator) {
        wait.until(driver -> {
            try {
                WebElement element = driver.findElement(locator);

                ((JavascriptExecutor) driver).executeScript(
                        "arguments[0].scrollIntoView({block: 'center'});",
                        element
                );

                element.click();
                return true;

            } catch (ElementClickInterceptedException |
                     StaleElementReferenceException e) {
                return false;
            }
        });
    }

    public WebElement waitForElementToBePresent(By locator) {
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(locator)
        );
    }

    public boolean waitForElementToDisappear(By locator) {
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(locator)
        );
    }

    public boolean waitForTextToBePresent(By locator, String text) {
        return wait.until(
                ExpectedConditions.textToBePresentInElementLocated(
                        locator, text
                )
        );
    }

    public Alert waitForAlert() {
        return wait.until(
                ExpectedConditions.alertIsPresent()
        );
    }
}
