package automation.base.steps;

import org.example.automation.config.ConfigReader;
import org.example.automation.pages.elements.ButtonsComponent;
import org.example.automation.pages.elements.CheckBoxComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigateSteps extends BaseSteps {
    //Elements
    private final By elementsLink = By.cssSelector("a[href='/elements']");
    private final By buttonsLink =
            By.cssSelector("a[href='/buttons']");
    private final By textBoxLink = By.cssSelector("a[href='/text-box']");
    private final By checkBoxLink = By.cssSelector("a[href='/checkbox']");

    public NavigateSteps(WebDriver driver) {
        super(driver);
    }

    public void openHomePage() {
        driver.get(ConfigReader.get("base.url"));
    }

    public NavigateSteps navigateToElementsPage() {
        click(elementsLink);
        return new NavigateSteps(driver);
    }

    public TextBoxSteps navigateToTextBox() {
        click(textBoxLink);
        return new TextBoxSteps(driver);
    }

    public void navigateToCheckBox() {
        click(checkBoxLink);
        new CheckBoxComponent(driver);
    }

    public void navigateToButtonsComponent() {
        click(buttonsLink);
        new ButtonsComponent(driver);
    }
}
