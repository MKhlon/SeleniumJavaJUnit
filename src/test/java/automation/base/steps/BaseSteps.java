package automation.base.steps;

import org.example.automation.pages.BasePage;

public class BaseSteps extends BasePage {
    private final BasePage basePage;

    public BaseSteps() {
        this.basePage = new BasePage();
    }

    public void clickSubmit() {
        basePage.clickSubmit();
    }
}
