package org.example.automation.pages.elements;

import org.example.automation.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBoxComponent extends BasePage {

    private final By collapsedTreeSwitcher =
            By.cssSelector("span.rc-tree-switcher_close");

    public CheckBoxComponent(WebDriver driver) {
        super(driver);
    }

    public void clickExpandTree() {
        click(collapsedTreeSwitcher);
    }
}
