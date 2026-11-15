package org.example.automation.pages.elements;

import org.example.automation.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UploadDownloadPage extends BasePage {

    private final By chooseFile = By.id("uploadFile");
    private final By uploadedFilePath = By.id("uploadedFilePath");

    public UploadDownloadPage(WebDriver driver) {
        super(driver);
    }
    public void uploadFile(String filePath) {
        WebElement uploadInput =
                waitUtils.waitForElementToBePresent(chooseFile);
        uploadInput.sendKeys(filePath);
    }

    public String getUploadedFilePath() {
        return getText(uploadedFilePath);
    }
}
